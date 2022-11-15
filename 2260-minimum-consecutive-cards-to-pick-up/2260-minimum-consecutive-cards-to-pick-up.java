class Solution {
    public int minimumCardPickup(int[] cards) {
        Set<Integer> set = new HashSet<>();
        int l = 0, r = 0, ans = Integer.MAX_VALUE;
        while (r < cards.length-1) {
            set.add(cards[r]);
            r++;
            // System.out.printf("window: [%d,%d]\n", l, r);
            while (set.contains(cards[r])) {
                set.remove(cards[l]);
                ans = Math.min(ans, r-l+1);
                l++;
            }
        }
        return ans == Integer.MAX_VALUE? -1 : ans;
    }
}