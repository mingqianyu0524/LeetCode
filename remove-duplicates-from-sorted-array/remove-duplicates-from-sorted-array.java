class Solution {
    public int removeDuplicates(int[] nums) {
        int l = 0, r = 0;
        while (r < nums.length) {
            int prev = nums[r];
            nums[r] = nums[l];
            nums[l] = prev;
            l++;
            while (r < nums.length && nums[r] <= prev) r++;
        }
        return l;
    }
}