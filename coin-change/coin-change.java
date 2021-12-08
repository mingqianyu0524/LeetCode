class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        for (int i=0; i<dp.length; ++i) dp[i] = Integer.MAX_VALUE;
        dp[0] = 0;
        for (int w=1; w<=amount; ++w) {
            for (int i=0; i<coins.length; ++i) {
                if (w >= coins[i]) {
                    if (dp[w-coins[i]] != Integer.MAX_VALUE)
                        dp[w] = Math.min(dp[w-coins[i]]+1, dp[w]);
                }
            }
        }
        if (dp[amount] == Integer.MAX_VALUE) return -1;
        return dp[amount];
    }
}