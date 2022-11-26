class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        backtrack(candidates, new ArrayList<Integer>(), 0, target);
        return res;
    }
    private void backtrack(int[] A, List<Integer> curr, int i, int t) {
        if (t == 0) res.add(new ArrayList<Integer>(curr));
        if (t < 0) return;
        for (int j = i; j < A.length; j++) {
            curr.add(A[j]);
            backtrack(A, curr, j, t-A[j]);
            curr.remove(curr.size()-1);
        }
    }
}