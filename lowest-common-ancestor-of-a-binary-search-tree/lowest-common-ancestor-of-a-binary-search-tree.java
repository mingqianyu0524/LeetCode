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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int pVal = p.val;
        int qVal = q.val;
        int rootVal = root.val;
        
        if (pVal > rootVal && qVal > rootVal) return lowestCommonAncestor(root.right, p, q);
        if (pVal < rootVal && qVal < rootVal) return lowestCommonAncestor(root.left, p, q);
        return root;
    }
}