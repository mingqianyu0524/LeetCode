class Solution {
    private HashMap<Integer, Integer> memo;
    
    public int combinationSum4(int[] nums, int target) {
        memo = new HashMap<>();
        return backtrack(nums, target);
    }
    
    private int backtrack(int[] nums, int rem) {
        if (rem == 0) return 1;
        if (memo.containsKey(rem)) return memo.get(rem);
        
        int res = 0;
        for (int num : nums) {
            if (num <= rem) 
                res += backtrack(nums, rem-num);
        }
        memo.put(rem, res);
        return res;
    }
}