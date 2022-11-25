class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<Integer>(), nums);
        return res;
    }
    private void backtrack(List<List<Integer>> res, List<Integer> curr, int[] nums) {
        if (curr.size() == nums.length) res.add(new ArrayList(curr));
        for (int num : nums) {
            if (!curr.contains(num)) {
                curr.add(num);
                backtrack(res, curr, nums);
                curr.remove(curr.size() - 1);
            }
        }
    }
}