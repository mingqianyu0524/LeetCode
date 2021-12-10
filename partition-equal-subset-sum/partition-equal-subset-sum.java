class Solution {
    public boolean canPartition(int[] nums) {
        int s = 0;
        for (int num : nums) s += num;
        int v = s/2;
        int w = s%2;
        int n = nums.length;
        if (w != 0) return false;
        boolean[][] T = new boolean[nums.length+1][v+1];
        
        T[0][0] = true;
    
        for (int i = 1; i < n+1; i++) {
            T[i][0] = true;
        }
        for (int j = 1; j < v+1; j++) {
            T[0][j] = false;
        }
        
        for (int i=1; i<=nums.length; ++i) {
            for (int j=0; j<=v; ++j) {
                if (j >= nums[i-1]) T[i][j] = T[i-1][j-nums[i-1]] || T[i-1][j];
                else T[i][j] = T[i-1][j];
            }
        }
        return T[nums.length][v];
    }
}