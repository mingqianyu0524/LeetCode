class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] min_price = new int[n];
        int[] max_profit = new int[n];
        
        min_price[0] = prices[0];
        max_profit[0] = 0;
        for (int i=1; i<n; ++i) {
            min_price[i] = Math.min(min_price[i-1], prices[i]);
            max_profit[i] = Math.max(max_profit[i-1], prices[i] - min_price[i]);
        }
        return max_profit[n-1];
    }
}