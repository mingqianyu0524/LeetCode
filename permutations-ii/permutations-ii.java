class Solution {
        private void dfs(int d, int[] nums, List<Integer> cur, boolean[] used, List<List<Integer>> ans) {
        if (d == nums.length) {
            ans.add(new ArrayList<Integer>(cur));
            return;
        }
        for (int i=0; i< nums.length; ++i) {
            // if the i_th number is already used previously in the cur array, continue
            if (used[i]) continue;
            if (i>0 && !used[i-1] && (nums[i-1] == nums[i])) continue;
            // Before recursion, add and occupy the number
            used[i] = true;
            cur.add(nums[i]);
            // Number occupied, thus can't be used in deeper recursion
            dfs(d+1, nums, cur, used, ans);
            cur.remove(cur.size()-1);
            // After recursion, remove and free the number
            used[i] = false;
        }
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(0, nums, new ArrayList<Integer>(), used, ans);
        return ans;
    }
}