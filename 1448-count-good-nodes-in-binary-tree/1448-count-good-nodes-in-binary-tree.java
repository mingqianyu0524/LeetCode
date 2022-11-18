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
    class Pair {
        TreeNode node;
        int maxSoFar;
        Pair(TreeNode node, int maxSoFar) {
            this.node = node;
            this.maxSoFar = maxSoFar;
        }
    }
    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, root.val));
        
        int ans = 0;
        while (!stack.isEmpty()) {
            Pair pair = stack.pop();
            TreeNode node = pair.node;
            int maxSoFar = pair.maxSoFar;
            if (node.val >= maxSoFar) ans++;
            
            TreeNode left = node.left;
            TreeNode right = node.right;
            
            if (left != null) {
                stack.push(new Pair(left, Math.max(maxSoFar, left.val)));
            }
            
            if (right != null) {
                stack.push(new Pair(right, Math.max(maxSoFar, right.val)));
            }
        }
        return ans;
        
    }
}