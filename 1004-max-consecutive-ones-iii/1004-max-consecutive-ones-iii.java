class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0, count = 0, res = 0;
        for (int r = 0; r < nums.length; r++ ) {
            if (nums[r] == 0) {
                count++;
            }
            while (l <= r && count > k) {
                if (nums[l] == 0) {
                    count--;
                }
                l++;
            }
            res = Math.max(res, r-l+1);
        }
        return res;
    }
}