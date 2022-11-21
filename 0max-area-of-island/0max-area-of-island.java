class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                max = Math.max(max, dfs(grid, i, j));
            }
        }
        return max;
    }
    private int dfs(int[][] M, int i, int j) {
        if (i < 0 || i >= M.length || j < 0 || j >= M[0].length || M[i][j] == 0) {
            return 0;
        }
        M[i][j] = 0;
        int a1 = dfs(M, i-1, j);
        int a2 = dfs(M, i+1, j);
        int a3 = dfs(M, i, j-1);
        int a4 = dfs(M, i, j+1);
        return a1+a2+a3+a4+1;
    }
}