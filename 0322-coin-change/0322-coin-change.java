class Solution {
    private static final int max = (int) 1e5;
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int k = 1; k <= amount; k++) {
            for (int coin : coins) {
                if (k >= coin)
                    dp[k] = Math.min(dp[k-coin]+1, dp[k]);
            }
        }
        return dp[amount] == max? -1 : dp[amount];
    }
}