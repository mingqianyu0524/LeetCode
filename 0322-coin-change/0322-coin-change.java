class Solution {
    Map<Integer, Integer> memo;
    public int coinChange(int[] coins, int amount) {
        memo = new HashMap<>();
        return dp(coins, amount) > (int) 1e4? -1 : dp(coins,amount);
    }
    private int dp(int[] coins, int k) {
        if (k <= 0) return k == 0 ? 0 : (int) 1e5;
        if (memo.containsKey(k)) return memo.get(k);
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            min = Math.min(dp(coins, k-coin)+1, min);
        }
        memo.put(k, min);
        return memo.get(k);
    }
}