class Solution {
    public int splitArray(int[] nums, int k) {
        int l = 0, r = (int) 1e9;
        while (l < r) {
            int mid = l + (r - l)/2;
            if (valid(nums, mid, k)) r = mid;
            else l = mid + 1;
        }
        return l;
    }
    private boolean valid(int[] A, int lim, int k) {
        int chunks = 0, i = 0;
        while (i < A.length) {
            if (A[i] > lim) return false;
            int sum = 0;
            while(i < A.length && A[i] + sum <= lim) sum += A[i++];
            chunks++;
        }
        return chunks <= k;
    }
}