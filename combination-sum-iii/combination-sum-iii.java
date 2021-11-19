class Solution {
    private void dfs(int k, int n, int start, List<Integer> cur, List<List<Integer>> ans) {
        if (k == 0) {
            if (n == 0) ans.add(new ArrayList<Integer>(cur));
            return;
        }    
        for (int i=start; i<=9; ++i) {
            if (i <= n) {
                cur.add(i);
                dfs(k-1, n-i, i+1, cur, ans);
                cur.remove(cur.size()-1);    
            }
        }
    }
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(k, n, 1, new ArrayList<Integer>(), ans);
        return ans;
    }
}