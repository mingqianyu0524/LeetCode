class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int majority = 0;
        for (int i=0; i<32; ++i) {
            int mask = 1 << i;
            int count = 0;
            for (int num : nums) {
                if ((mask & num) == mask) count++;
                if (count > n/2) {
                    majority |= mask;
                    break;
                }
            }
        }
        return majority;
    }
}