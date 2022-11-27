class Solution {
    Map<Integer, Integer> memo;
    public int climbStairs(int n) {
        memo = new HashMap<>();
        return dp(n);
    }
    private int dp(int i) {
        if (i == 0) return 1;
        if (i < 0) return 0;
        if (memo.containsKey(i)) return memo.get(i);
        memo.put(i, dp(i-1)+dp(i-2));
        return memo.get(i);
    }
}