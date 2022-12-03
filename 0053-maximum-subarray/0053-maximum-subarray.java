class Solution {
    public int maxSubArray(int[] nums) {
        return dc(nums, 0, nums.length-1);
    }
    private int dc(int[] nums, int l, int r) {
        if (l > r) 
            return Integer.MIN_VALUE;
        int mid = l + (r-l)/2;
        
        int sum = 0, left = 0, right = 0;
        for (int i = mid - 1; i >= l; i--) {
            sum += nums[i];
            left = Math.max(left, sum);
        }
        sum = 0;
        for (int j = mid + 1; j <= r; j++) {
            sum += nums[j];
            right = Math.max(right, sum);
        }
        int smid = nums[mid] + left + right;
        int sleft = dc(nums, l, mid-1);
        int sright = dc(nums, mid+1, r);
        return Math.max(sleft, Math.max(sright, smid));
    }
}