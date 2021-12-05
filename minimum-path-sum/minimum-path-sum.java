class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] T = new int[m][n];
        for (int i=0; i<m; ++i) {
            for (int j=0; j<n; ++j) {
                if (i==0 || j==0) {
                    if (j!=0) T[i][j] = T[i][j-1] + grid[i][j];
                    else if (i!=0) T[i][j] = T[i-1][j] + grid[i][j];
                    else T[i][j] = grid[i][j];
                }
                else T[i][j] = Math.min(T[i-1][j], T[i][j-1])+grid[i][j];
            }
        }
        return T[m-1][n-1];
    }
}