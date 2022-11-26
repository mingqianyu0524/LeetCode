class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        backtrack(new ArrayList<Integer>(), n, k, 1);
        return res;
    }
    private void backtrack(List<Integer> curr, int n, int k, int i) {
        if (n == 0 && k == 0) res.add(new ArrayList<Integer>(curr));
        if (n < 0 || k < 0) return;
        for (int j = i; j < 10; j++) {
            curr.add(j);
            backtrack(curr, n-j, k-1, j+1);
            curr.remove(curr.size()-1);
        }
    }
}