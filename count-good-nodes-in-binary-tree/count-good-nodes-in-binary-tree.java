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
    private int counter = 0;
    private void dfs(TreeNode root, int max) {
        if (root != null) {
            if (root.val >= max) {
                max = root.val;
                counter ++;
            }
            dfs(root.left, max);
            dfs(root.right, max);
        }
    }
    public int goodNodes(TreeNode root) {
        int max = root.val;
        dfs(root, max);
        return counter;
    }
}