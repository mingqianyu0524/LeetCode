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
    public int minDepth(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int res = Integer.MAX_VALUE;
        if (root == null) return 0;
        q.offer(root);
        int level = 1;
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i=0; i<n; ++i) {
                TreeNode node = q.poll();
                if (node.left == null && node.right == null) {
                    //found a leaf node
                    if (level < res) res = level;
                }
                else {
                    if (node.left!=null) q.offer(node.left);
                    if (node.right!=null) q.offer(node.right);
                }
            }
            ++level;
        }
        return res;
    }
}