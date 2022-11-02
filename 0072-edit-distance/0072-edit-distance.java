class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        // initialization
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        // dp
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int left = dp[i][j-1];
                int up = dp[i-1][j];
                int upleft = dp[i-1][j-1];
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    upleft--;
                }
                dp[i][j] = Math.min(left, Math.min(up, upleft)) + 1;
            }
        }
        return dp[m][n];
    }
}