class Solution {
    private int[][] memo;
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        memo = new int[m][n];
        for (int[] row : memo)
            Arrays.fill(row, -1);
        memo[0][0] = dp(obstacleGrid, m, n, 0, 0);
        return memo[0][0];
    }
    
    private int dp(int[][] M, int m, int n, int r, int c) {
        if (r >= m || c >= n)
            return 0;
        if (M[r][c] == 1)
            memo[r][c] = 0;
        if (M[r][c] == 0 && r == m - 1 && c == n - 1)
            return 1;
        if (memo[r][c] != -1)
            return memo[r][c];
        memo[r][c] = dp(M, m, n, r, c+1) + dp(M, m, n, r+1, c);
        return memo[r][c];
    }
    
}