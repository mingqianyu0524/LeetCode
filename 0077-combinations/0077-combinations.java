class Solution {
    List<List<Integer>> res;
    int n;
    public List<List<Integer>> combine(int n, int k) {
        this.res = new ArrayList<>();
        this.n = n;
        backtrack(new ArrayList<Integer>(), 1, k);
        return res;
    }
    private void backtrack(List<Integer> curr, int i, int k) {
        if (k == 0) res.add(new ArrayList<Integer>(curr));
        for (int j = i; j <= n; j++) {
            curr.add(j);
            backtrack(curr, j+1, k-1);
            curr.remove(curr.size() - 1);
        }
    }
}