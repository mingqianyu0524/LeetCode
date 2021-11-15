class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, target, new ArrayList<Integer>(), ans);
        return ans;
    }
    
    private void dfs(int[] candidates, int start, int target, List<Integer> cur, List<List<Integer>> ans) {
        if (target < 0) return;
        if (target == 0) {
            // figure this next line out
            ans.add(new ArrayList(cur));
            return;
        }        
        for (int j=start;j<candidates.length;++j) {
            cur.add(candidates[j]);
            dfs(candidates, j, target-candidates[j], cur, ans);
            cur.remove(cur.size()-1);
        }
    }
}