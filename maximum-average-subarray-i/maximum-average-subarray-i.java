class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double res = 0;
        for (int i = 0; i < k; i++) {
            res += nums[i];
        }
        double sum = res;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i-k];
            res = Math.max(res, sum);
        }
        return res/k;
    }
}