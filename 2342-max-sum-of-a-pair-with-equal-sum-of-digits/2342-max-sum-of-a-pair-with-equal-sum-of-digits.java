class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = -1;
        for (int num : nums) {
            int digitSum = digitSum(num);
            if (map.containsKey(digitSum)) {
                ans = Math.max(ans, num + map.get(digitSum));
            }
            map.put(digitSum, Math.max(num, map.getOrDefault(digitSum, 0)));
        }
        return ans;
    }
    private int digitSum(int x) {
        int ans = 0;
        while (x > 0) {
            ans += x%10;
            x /= 10;
        }
        return ans;
    }
}