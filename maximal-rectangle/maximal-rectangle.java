class Solution {
    public int maximalRectangle(char[][] matrix) {
        int r = matrix.length;
        // edge case
        if (r == 0) return 0;
        int c = matrix[0].length;
                
        int[][] dp = new int[r][c];
        for (int i=0; i<r; ++i) {
            for (int j=0; j<c; ++j) {
                if (matrix[i][j] == '0') dp[i][j] = 0;
                else {
                    if (j == 0) dp[i][j] = 1;
                    else dp[i][j] = dp[i][j-1] + 1;    
                }
            }
        }
        
        int ans = 0;
        for (int i=0; i<r; ++i) {
            for (int j=0; j<c; ++j) {
                int len = Integer.MAX_VALUE;
                for (int k=i; k<r; ++k) {
                    len = Math.min(len, dp[k][j]);
                    if (len == 0) break;
                    ans = Math.max(ans, len*(k-i+1));
                }
            }
        }
        return ans;
    }
}