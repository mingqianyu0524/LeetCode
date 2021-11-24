class Solution {
    private void dp(int[] T, int[] V) {
        for (int i=2;i< T.length;++i)
            T[i] = Math.max(T[i-1], T[i-2] + V[i]);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] T = new int[n];
        T[0] = nums[0];
        T[1] = Math.max(nums[0], nums[1]);
        dp(T, nums);
        return T[T.length-1];
    }
}