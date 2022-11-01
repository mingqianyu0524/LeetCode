class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int prev = nums[0];
        if (n == 1) return nums[0];
        int cur = Math.max(nums[0], nums[1]);
        // steal the first house
        for (int i = 2; i < n-1; i++) {
            int tmp = prev;
            prev = cur;
            cur = Math.max(tmp + nums[i], cur);
        }
        int res = cur;
        // reset
        prev = 0;
        cur = nums[1];
        // steal the last house
        for (int i = 2; i < n; i++) {
            int tmp = prev;
            prev = cur;
            cur = Math.max(tmp + nums[i], cur);
        }
        return Math.max(res, cur);
    }
}