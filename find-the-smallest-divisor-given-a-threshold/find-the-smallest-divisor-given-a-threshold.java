class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int l = 1, r = max;
        while (l < r) {
            int k = l + (r - l)/2, sum = 0;
            for (double num : nums) {
                sum += Math.ceil(num/k);
            }
            if (sum <= threshold) r = k;
            else l = k + 1;
        }
        return l;
    }
}