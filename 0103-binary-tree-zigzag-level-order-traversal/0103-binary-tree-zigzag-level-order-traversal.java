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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        boolean orderLeft = false;
        List<List<Integer>> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            int n = queue.size();
            orderLeft = orderLeft == false ? true : false;
            LinkedList<Integer> currLevel = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                
                if (!orderLeft) {
                    currLevel.addFirst(node.val);    
                } else {
                    currLevel.addLast(node.val);
                }
                
                // System.out.printf("Node value: %d, order: %s\n", node.val, orderLeft);
                
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            ans.add(currLevel);
        }
        return ans;
    }
}