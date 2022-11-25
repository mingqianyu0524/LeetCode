class Solution {
    private List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        for (int k = 0; k <= nums.length; k++) {
            backtrack(new ArrayList<Integer>(), nums, 0, k);
        }
        return res;
    }
    private void backtrack(List<Integer> curr, int[] nums, int i, int k) {
        if (k == 0) 
            res.add(new ArrayList<Integer>(curr));
        
        for (int j = i; j < nums.length; j++) {
            curr.add(nums[j]);
            backtrack(curr, nums, j+1, k-1);
            curr.remove(curr.size() - 1);
        }
    }
}