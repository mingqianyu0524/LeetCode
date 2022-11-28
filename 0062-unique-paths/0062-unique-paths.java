class Solution {
    int[][] memo;
    public int uniquePaths(int m, int n) {
        memo = new int[m][n];
        for (int[] row : memo) 
            Arrays.fill(row, -1);
        return dfs(m, n, 0, 0);
    }
    private int dfs(int m, int n, int r, int c) {
        if (r >= m || c >= n) return 0;
        if (r == m-1 && c == n-1) return 1;
        if (memo[r][c] != -1) return memo[r][c];
        memo[r][c] = dfs(m, n, r+1, c) + dfs(m, n, r, c+1);
        return memo[r][c];
    }
}