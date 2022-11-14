class Solution {
    public int missingNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int expected = nums.length + 1;
        for (int i = 0; i < expected; i++) {
            if (!set.contains(i)) return i;
        }
        return -1;
    }
}