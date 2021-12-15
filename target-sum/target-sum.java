class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums)
            sum += num;
        if (sum < target) return 0;
        final int offset = sum;
        int[][] dp = new int[n+1][sum+offset+1];
        dp[0][offset] = 1;
        for (int i=0; i<n; ++i) {
            for (int j=nums[i]; j<2*sum+1-nums[i]; ++j) {
                if (dp[i][j] >= 0) {
                    dp[i+1][j+nums[i]] += dp[i][j];
                    dp[i+1][j-nums[i]] += dp[i][j];
                }
            }
        }
        return target+offset>=0 ? dp[n][target + offset]: 0;
    }
}