/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int closestValue(TreeNode root, double target) {
        List<Integer> list = dfs(root);
        return Collections.min(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o1-target) < Math.abs(o2-target)? -1 : 1;
            }
        });
    }
    private List<Integer> dfs(TreeNode node) {
        if (node == null) return new ArrayList<>();
        List<Integer> ans = dfs(node.left);
        ans.add(node.val);
        ans.addAll(dfs(node.right));
        return ans;
    }
}