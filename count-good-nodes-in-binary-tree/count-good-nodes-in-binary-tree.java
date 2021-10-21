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
class Pair {
    public TreeNode node;
    public int maxSoFar;
    public Pair(TreeNode node, int maxSoFar) {
        this.node = node;
        this.maxSoFar = maxSoFar;
    }
}
class Solution {
    public int goodNodes(TreeNode root) {
        int counter = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, Integer.MIN_VALUE));
        
        while (queue.size() > 0) {
            Pair curr = queue.poll();
            if (curr.maxSoFar <= curr.node.val) {
                counter++;
            }
            if (curr.node.left != null) {
                queue.offer(new Pair(curr.node.left, Math.max(curr.node.val, curr.maxSoFar)));
            }
            if (curr.node.right != null) {
                queue.offer(new Pair(curr.node.right, Math.max(curr.node.val, curr.maxSoFar))); 
            }
        }
        return counter;
    }
}