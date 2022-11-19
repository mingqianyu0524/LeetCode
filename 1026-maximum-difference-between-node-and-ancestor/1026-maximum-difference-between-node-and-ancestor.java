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
    class Tuple {
        TreeNode node;
        int min;
        int max;
        Tuple(TreeNode node, int min, int max) {
            this.node = node;
            this.min = min;
            this.max = max;
        }
    }
    public int maxAncestorDiff(TreeNode root) {
        Stack<Tuple> stack = new Stack<>();
        stack.push(new Tuple(root, root.val, root.val));
        int v = 0;
        while (!stack.isEmpty()) {
            Tuple tuple = stack.pop();
            TreeNode node = tuple.node;
            int min = tuple.min;
            int max = tuple.max;
            
            v = Math.max(v, Math.max(Math.abs(node.val-max), Math.abs(node.val-min)));
            
            TreeNode l = node.left, r = node.right;
            int minL = min, minR = min, maxL = max, maxR = max;
            if (l != null) {
                minL = Math.min(l.val, min);
                maxL = Math.max(l.val, max);
                stack.push(new Tuple(l, minL, maxL));
            }
            if (r != null) {
                minR = Math.min(r.val, min);
                maxR = Math.max(r.val, max);
                stack.push(new Tuple(r, minR, maxR));
            }
        }
        return v;
    }
}