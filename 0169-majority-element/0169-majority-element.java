class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                int o = map.get(num) + 1;
                map.put(num, o);
                
            }
            int o = map.get(num);
            if (o > n/2) return num;
        }
        return -1;
    }
}