class Solution {
    public int subarraySum(int[] nums, int k) {
        int ans = 0, curr = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            curr += num;
            ans += map.getOrDefault(curr-k, 0);
            int val = map.getOrDefault(curr, 0) + 1;
            map.put(curr, val);
        }
        return ans;
    }
}