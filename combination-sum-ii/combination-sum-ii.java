class Solution {
    private void dfs(List<List<Integer>> ans, int[] candidates, ArrayList<Integer> cur, int target, int start) {
        if (target == 0) {
            ans.add(new ArrayList<Integer>(cur));
            return;
        }
        for (int i=start;i<candidates.length;++i) {
            if (candidates[i] > target) break;
            if (i>start && candidates[i] == candidates[i-1]) continue;
            cur.add(candidates[i]);
            // no duplicated candidates: start = i+1
            dfs(ans, candidates, cur, target - candidates[i], i+1);
            cur.remove(cur.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(ans, candidates, new ArrayList<Integer>(), target, 0);
        return ans;
    }
}