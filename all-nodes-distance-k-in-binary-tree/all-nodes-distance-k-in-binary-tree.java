/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<TreeNode, List<TreeNode>> map = new HashMap();
    private void buildMap(TreeNode node, TreeNode parent) {
        if (node == null) return;
        if (!map.containsKey(node)) {
            map.put(node, new ArrayList<TreeNode>());
            if (parent != null)  { map.get(node).add(parent); map.get(parent).add(node) ; }
            buildMap(node.left, node);
            buildMap(node.right, node);
        }
    }    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        if (root == null || K<0) {
            return res;
        }
        buildMap(root, null);
        if (!map.containsKey(target)) return res;
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        visited.add(target);
        q.add(target);
        // initiate dist
        int k = 0;
        while (!q.isEmpty()) {
            int s = q.size();
            if (k == K) {
                for (int i=0;i<s;i++) {
                    res.add(q.poll().val);
                }
                return res;
            }
            for (int i=0;i<s;i++) {
                TreeNode node = q.poll();
                for (TreeNode next : map.get(node)) {
                    if (visited.contains(next)) continue;
                    visited.add(next);
                    q.add(next);
                }
            }
            K--;
        }
        return res;
    }
}