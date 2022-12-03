class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(0, dp[i-1]) + nums[i];
        }
        int max = Integer.MIN_VALUE;
        for (int s : dp) {
            max = Math.max(max, s);
        }
        return max;
    }
}