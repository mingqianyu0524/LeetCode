class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int first = 0, second = 0;
        for (int i = 2; i <= cost.length; i++) {
            int third = second;
            second = Math.min(second + cost[i-1], first + cost[i-2]);
            first = third;
        }
        return second;
    }
}