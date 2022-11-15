class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int digitSum = digitSum(nums[i]);
            if (!map.containsKey(digitSum)) {
                map.put(digitSum, new ArrayList<Integer>());
            }
            map.get(digitSum).add(nums[i]);
        }
        int ans = -1;
        for (int key : map.keySet()) {
            List<Integer> ls = map.get(key);
            if (ls.size() > 1) {
                Collections.sort(ls, Collections.reverseOrder());    
                ans = Math.max(ans, ls.get(0) + ls.get(1));
            }
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