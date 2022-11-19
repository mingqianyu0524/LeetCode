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
    public int rangeSumBST(TreeNode node, int lo, int hi) {
        int sum = 0;
        if (node == null) return 0;
        if (lo <= node.val && node.val <= hi) {
            sum += node.val;
        }
        if (lo < node.val) 
            sum += rangeSumBST(node.left, lo, hi);
        if (hi > node.val) 
            sum += rangeSumBST(node.right, lo, hi);
        return sum;
    }
}