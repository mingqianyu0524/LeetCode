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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> cur = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();
        if (root == null) return res;
        cur.add(root);
        while (!cur.isEmpty()) {
            long sum = 0;
            for (TreeNode node : cur) {
                sum += node.val;
                if (node.left != null) next.add(node.left);
                if (node.right != null) next.add(node.right);
            }
            res.add(sum / new Double(cur.size()));
            cur = next;
            next = new LinkedList<TreeNode>();
        }
        return res;
    }
}