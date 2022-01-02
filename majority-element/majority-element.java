class Solution {
    public int majorityElement(int[] nums) {
        int ceil = Math.floorDiv(nums.length, 2);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) map.put(num, 1);
            else {
                int value = map.get(num);
                if (value+1>ceil) return num;
                map.put(num, value+1);
            }
        }
        return nums[0];
    }
}