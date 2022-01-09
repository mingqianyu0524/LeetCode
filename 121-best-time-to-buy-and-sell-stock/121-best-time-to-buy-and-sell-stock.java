class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] gain = new int[n-1];
        for (int i=1; i<n; ++i) 
            gain[i-1] = prices[i] - prices[i-1];
        int max_profit = 0, global_max = 0;
        for (int j=0; j<n-1; ++j) {
            max_profit = Math.max(max_profit + gain[j], gain[j]);
            global_max = Math.max(global_max, max_profit);
        }
        return global_max;
    }
}