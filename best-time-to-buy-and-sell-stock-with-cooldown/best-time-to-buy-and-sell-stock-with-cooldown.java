class Solution {
    public int maxProfit(int[] prices) {
        // state machine
        int sold = Integer.MIN_VALUE;
        int hold = Integer.MIN_VALUE;
        int rest = 0;
        
        for (int price : prices) {
            int prev_sold = sold;
            sold = hold + price;
            hold = Math.max(hold, rest - price);
            rest = Math.max(rest, prev_sold);
        }
        return Math.max(sold, rest);
    }
}