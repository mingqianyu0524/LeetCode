class Solution {
    public int uniquePathsWithObstacles(int[][] M) {
        int m = M.length, n = M[0].length;
        int[][] dp = new int[m+1][n+1];
        for (int r = 1; r <= m; r++) {
            for (int c = 1; c <= n; c++) {
                if (M[r-1][c-1] != 1 && r == 1 && c == 1) dp[r][c] = 1;
                else {
                    if (M[r-1][c-1] == 0) {
                        if (r > 0) dp[r][c] += dp[r-1][c];    
                        if (c > 0) dp[r][c] += dp[r][c-1];
                    } 
                    else dp[r][c] = 0;
                }
            }
        }
        return dp[m][n];
    }
}