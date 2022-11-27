class Solution {
    Map<Integer, Integer> memo;
    public int minCostClimbingStairs(int[] cost) {
        memo = new HashMap<>();
        return dp(cost, cost.length);
    }
    private int dp(int[] cost, int i) {
        if (i <= 1) return 0;
        if (memo.containsKey(i))
            return memo.get(i);
        memo.put(i, Math.min(dp(cost, i-1) + cost[i-1], dp(cost, i-2) + cost[i-2]));
        return memo.get(i);
    }
}