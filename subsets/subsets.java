class Solution {
    private void dfs(int[] nums, int k, int start, ArrayList<Integer> cur, List<List<Integer>> ans) {
        int n = nums.length;
        if (k == 0) {
            ans.add(new ArrayList<Integer>(cur));
            return;
        }
        for (int i=start; i<n; ++i) {
            cur.add(nums[i]);
            dfs(nums, k-1, i+1, cur, ans);
            cur.remove(cur.size()-1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for (int k=0; k<=n; ++k) {
            dfs(nums, k, 0, new ArrayList<Integer>(), ans);
        }
        return ans;
    }
}