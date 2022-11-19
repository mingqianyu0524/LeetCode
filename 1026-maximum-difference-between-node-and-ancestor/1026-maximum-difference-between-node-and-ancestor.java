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
    private int v;
    
    public int maxAncestorDiff(TreeNode root) {
        v = 0;
        dfs(root, root.val, root.val);
        return v;
    }
    
    private void dfs(TreeNode node, int min, int max) {
        if (node == null) return;
        v = Math.max(v, Math.max(Math.abs(node.val - min), Math.abs(node.val - max)));
        min = Math.min(node.val, min);
        max = Math.max(node.val, max);
        dfs(node.left, min, max);
        dfs(node.right, min, max);
        return;
    }
}