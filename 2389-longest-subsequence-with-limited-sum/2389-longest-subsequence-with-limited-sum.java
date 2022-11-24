class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i-1] + nums[i];
        }
        for (int i = 0; i < queries.length; i++) {
            int l = 0, r = nums.length - 1;
            boolean found = false;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] == queries[i]) {
                    queries[i] = mid + 1;
                    found = true;
                }
                else if (nums[mid] < queries[i]) l = mid + 1;
                else r = mid - 1;
            }
            if (!found) queries[i] = l;
        }
        return queries;
    }
}