class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        
        int l = 0, r = max;
        while (l < r) {
            int k = l + (r - l)/2;          
            if (check(piles, k, h)) r = k;
            else l = k + 1;
        }
        return l;
    }
    
    private boolean check(int[] piles, int k, int h) {
        long hours = 0;
        for (int pile : piles) {
            hours += Math.ceil((double) pile/k);
        }
        return hours <= h ;
    }
}