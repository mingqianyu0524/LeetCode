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
    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = dfs(root);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < list.size() - 1; i++) {
            ans = Math.min(ans, Math.abs(list.get(i) - list.get(i+1)));
        }
        return ans;
    }
    private List<Integer> dfs(TreeNode node) {
        if (node == null) return new ArrayList<>();
        List<Integer> ans = dfs(node.left);
        ans.add(node.val);
        ans.addAll(dfs(node.right));
        return ans;
    }
}