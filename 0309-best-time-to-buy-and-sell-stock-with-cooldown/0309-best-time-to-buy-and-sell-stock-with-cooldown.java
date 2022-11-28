class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[2][n+2];
        int count = 0;
        for (int[] row : dp) {
            if (count == 0) Arrays.fill(row, 0);
            else Arrays.fill(row, Integer.MIN_VALUE);
            ++count;
        }
        for (int i = 2; i < n + 2; i++) {
            dp[0][i] = Math.max(dp[0][i-1], prices[i-2]+dp[1][i-1]);
            dp[1][i] = Math.max(dp[1][i-1], -prices[i-2]+dp[0][i-2]);
        }
        return dp[0][n+1];
    }
}