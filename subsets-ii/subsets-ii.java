class Solution {
    private void dfs(int[] nums, int k, int start, ArrayList<Integer> cur, List<List<Integer>> ans) {
        int n = nums.length;
        if (k == 0) {
            ans.add(new ArrayList<Integer>(cur));
            return;
        }
        for (int i=start; i<n; ++i) {
            if ((start < i) && (nums[i] == nums[i-1])) continue;
            cur.add(nums[i]);
            dfs(nums, k-1, i+1, cur, ans);
            cur.remove(cur.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int k=0; k<=n; ++k) {
            dfs(nums, k, 0, new ArrayList<Integer>(), ans);
        }
        return ans;
    }
}