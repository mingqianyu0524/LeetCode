class Solution {
    private int[][] memo;
    
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        memo = new int[m][n];
        for (int[] row : memo)
            Arrays.fill(row, -1);
        dp(grid, m, n, 0, 0);
        return memo[0][0];
    }
    
    private int dp(int[][] M, int m, int n, int i, int j) {
        if (i >= m || j >= n)
            return Integer.MAX_VALUE;
        if (i == m - 1 && j == n - 1) {
            memo[i][j] = M[i][j];
        }
        if (memo[i][j] != -1)
            return memo[i][j];
        memo[i][j] = Math.min(dp(M, m, n, i+1, j), dp(M, m, n, i, j+1)) + M[i][j];
        return memo[i][j];
    }
}