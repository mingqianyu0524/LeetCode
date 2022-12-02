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
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
    private TreeNode helper(int[] nums, int l, int r) {
        if (l > r) return null;
        int mid = l + (r - l) / 2;
        TreeNode left = helper(nums, l, mid - 1);
        TreeNode right = helper(nums, mid + 1, r);
        return new TreeNode(nums[mid], left, right);
    }
}