class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        
        for (int i=0;i<nums.length;++i) {
            if (i == 0) {
                dp1[0] = nums[0];
                dp2[0] = 0;
                continue;
            }
            if (i == 1) {
                dp1[1] = Math.max(dp1[0], nums[1]);
                dp2[1] = Math.max(dp2[0], nums[1]);
                continue;
            }
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + nums[i]);
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + nums[i]);
        }
        if (n == 1) return nums[0];
        return Math.max(dp1[n-2], dp2[n-1]);
    }
}