class Solution {
    public int maxProfit(int[] prices) {
        // max_profit: max_profit from day[1, ..., i];
        // min_price: min_price from day[1, ..., i];
        // Target: Find max_profit on the n_th day, 1D DP -> updating vars.
        int n = prices.length;
        int min_price = prices[0], max_profit = 0;
        
        for (int i=1; i<n; ++i) {
            min_price = Math.min(prices[i], min_price);
            max_profit = Math.max(max_profit, prices[i] - min_price);
        }
        return max_profit;
    }
}