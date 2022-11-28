class Solution {
    int[][] memo;
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        memo = new int[m][n];
        for (int[] row : memo)
            Arrays.fill(row, Integer.MAX_VALUE);
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, dp(matrix, m, n, 0, i));
        }
        return min;
    }
    
    private int dp(int[][] M, int m, int n, int r, int c) {
        if (c < 0 || c >= n)
            return Integer.MAX_VALUE;
        if (r == m - 1)
            memo[r][c] = M[r][c];
        if (memo[r][c] < Integer.MAX_VALUE)
            return memo[r][c];
        memo[r][c] = Math.min(dp(M,m,n,r+1,c-1), Math.min(dp(M,m,n,r+1,c),dp(M,m,n,r+1,c+1))) + M[r][c];
        return memo[r][c];
    }
}