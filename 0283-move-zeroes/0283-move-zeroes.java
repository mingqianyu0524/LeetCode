class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0, j = 0, n = nums.length;
        while (i < n && j < n) {
            while (i < n && nums[i] != 0) i++;
            j = i;
            while (j < n && nums[j] == 0) j++;
            if (i < n && j < n) 
                swap(nums, i, j);
        }
    }
    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}