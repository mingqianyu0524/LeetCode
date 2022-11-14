class Solution {
    public List<Integer> intersection(int[][] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int[] arr = nums[i];
            for (int j = 0; j < arr.length; j++) {
                int num = arr[j];
                int c = count.getOrDefault(num, 0) + 1;
                count.put(num, c);
                if (c == n) res.add(num);
            }
        }
        Collections.sort(res);
        return res;
    }
}