class Solution {
    public int minStartValue(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        int min = prefix[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i-1] + nums[i];
            min = prefix[i] < min? prefix[i] : min;
        }
        
        return min > 0? 1 : 1- min;
    }
}