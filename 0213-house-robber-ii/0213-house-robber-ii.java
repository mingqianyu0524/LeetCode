class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        if (n == 1) return nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        // steal the first house
        for (int i = 2; i < n-1; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }
        int res = dp[n-2];
        // reset the array
        Arrays.fill(dp, 0);
        dp[1] = nums[1];
        // steal the last house
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }
        return Math.max(res, dp[n-1]);
    }
}