class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int prev = nums[0];
        if (n == 1) return prev;
        int cur = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            int tmp = prev;
            prev = cur;
            cur = Math.max(tmp + nums[i], cur);
        }
        return cur;
    }
}