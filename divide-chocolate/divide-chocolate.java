class Solution {
    public int maximizeSweetness(int[] sweetness, int k) {
        int l = 1, r = (int) 1e9 / (k + 1);
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            int curr = 0, cuts = 0;
            for (int s : sweetness) {
                if ((curr += s) >= mid) {
                    curr = 0;
                    if (++cuts > k) break;
                }
            }
            if (cuts > k) l = mid;
            else r = mid - 1;
        }
        return l;
    }
}