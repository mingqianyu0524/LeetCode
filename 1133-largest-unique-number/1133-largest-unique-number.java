class Solution {
    public int largestUniqueNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int count = map.getOrDefault(num, 0)+1;
            map.put(num, count);
        }
        int ans = Integer.MIN_VALUE;
        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                ans = Math.max(ans, key);
            }
        }
        return ans == Integer.MIN_VALUE? -1 : ans;
    }
}