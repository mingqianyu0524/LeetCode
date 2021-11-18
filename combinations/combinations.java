class Solution {
    private void dfs(int n, int k, int start, ArrayList<Integer> cur, List<List<Integer>> ans) {
        if (k == 0) {
            ans.add(new ArrayList<Integer>(cur));
            return;
        }
        for (int i=start; i<=n; ++i) {
            cur.add(i);
            dfs(n, k-1, i+1, cur, ans);
            cur.remove(cur.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(n, k, 1, new ArrayList<Integer>(), ans);
        return ans;
    }
}