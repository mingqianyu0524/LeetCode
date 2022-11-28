class Solution {
    int[][] memo;
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        memo = new int[n][n];
        for (int[] row : memo)
            Arrays.fill(row, Integer.MAX_VALUE);
        
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            min = Math.min(min, dp(matrix, n, 0, j));
        }
        return min;
    }
    
    private int dp(int[][] M, int n, int r, int c) {
        if (c < 0 || c >= n)
            return Integer.MAX_VALUE;
        if (r == n - 1)
            memo[r][c] = M[r][c];
        if (memo[r][c] < Integer.MAX_VALUE)
            return memo[r][c];
        memo[r][c] = Math.min(dp(M,n,r+1,c-1), Math.min(dp(M,n,r+1,c),dp(M,n,r+1,c+1))) + M[r][c];
        return memo[r][c];
    }
}