class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int val = map.getOrDefault(num, 0) + 1;
            map.put(num, val);
        }
        for (int key : map.keySet()) {
            if (map.get(key) == 1) return key;
        }
        return -1;
    }
}