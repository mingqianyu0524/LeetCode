class Solution {
    private void dfs(int d, int[] nums, List<Integer> cur, boolean[] used, List<List<Integer>> ans) {
        if (d == nums.length) {
            ans.add(new ArrayList<Integer>(cur));
            return;
        }
        for (int i=0; i< nums.length; ++i) {
            if (used[i]) continue;
            used[i] = true;
            cur.add(nums[i]);
            dfs(d+1, nums, cur, used, ans);
            cur.remove(cur.size()-1);
            used[i] = false;
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        boolean[] used = new boolean[n];
        List<List<Integer>> ans = new ArrayList<>();
        dfs(0, nums, new ArrayList<Integer>(), used, ans);
        return ans;
    }
}