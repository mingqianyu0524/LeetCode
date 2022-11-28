class Solution {
    public int uniquePaths(int m, int n) {
        int dp[] = new int[n];
        dp[0] = 1;
        
        for (int row = 0; row < m; row++) {
            int[] nextRow = new int[n];
            for (int col = 0; col < n; col++) {
                nextRow[col] += dp[col];
                if (col > 0) {
                    nextRow[col] += nextRow[col - 1];
                }
            }
            dp = nextRow;
        }
        
        return dp[n - 1];
    }
}