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
    private TreeNode res;
    
    public Solution() {
        this.res = null;
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.recurseTree(root, p, q);
        return this.res;
    }
    
    private boolean recurseTree(TreeNode cur, TreeNode p, TreeNode q) {
        if (cur == null) {
            return false;
        }
        int left = recurseTree(cur.left, p, q)? 1:0;
        int right = recurseTree(cur.right, p, q)?1:0;
        int mid = (cur == p || cur == q)?1:0;
        if (left+right+mid>=2) {
            this.res = cur;
        }
        return (left+right+mid>0);
    }
}