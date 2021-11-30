class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        // S: let T_i = minimum cost from the first step uptil i
        // R: T_i = min{(T_i-2 + cost_i-2), (T_i-1 + cost_i-1)}
        // T: for i = 2 to n.length-1 (Topology)
        // B: T_0 = cost[0], T_1 = min{cost[0], cost[1]}
        // O: T_n where n = cost.length
        // T: O(n)
        
        int[] dp = new int[cost.length+1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i=2; i<=cost.length; ++i) {          
            dp[i] = Math.min(dp[i-2] + cost[i-2], dp[i-1] + cost[i-1]);
        }
        return dp[cost.length];
    }
}