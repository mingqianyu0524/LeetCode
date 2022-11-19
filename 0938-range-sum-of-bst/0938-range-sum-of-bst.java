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
    private int sum;
    public int rangeSumBST(TreeNode root, int low, int high) {
        sum = 0;
        dfs(root, low, high);
        return sum;
    }
    private void dfs(TreeNode node, int lo, int hi) {
        if (node == null) return;
        if (lo <= node.val && node.val <= hi) {
            sum += node.val;
            dfs(node.left, lo, hi);
            dfs(node.right, lo, hi);
        }
        else if (lo > node.val) dfs(node.right, lo, hi);
        else if (hi < node.val) dfs(node.left, lo, hi);
        return;
    }
}