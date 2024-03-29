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
    private int d = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return d;
    }
    private int dfs(TreeNode root) {
        if (root == null || (root.left == null && root.right ==null)) return 0;
        if (root.left == null && root.right!= null) {
            int x = dfs(root.right);
            d = Math.max(x+1, d);
            return x+1;
        }
        if (root.right == null && root.left != null) {
            int x = dfs(root.left);
            d = Math.max(x+1, d);
            return x+1;
        }
        int l = dfs(root.left);
        int r = dfs(root.right);
        int x = l+r+2;
        d = Math.max(x, d);
        int y = Math.max(l, r);
        return y+1;
    }
}