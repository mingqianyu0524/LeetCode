class Solution {
    public void dfs(char[][] M, int i, int j) {
        int m = M.length;
        int n = M[0].length;
        if (i<0 || j<0 || i>=m || j>=n || M[i][j] == '0') {
            return;
        }
        
        M[i][j] = '0';
        dfs(M, i-1, j);
        dfs(M, i+1, j);
        dfs(M, i, j-1);
        dfs(M, i, j+1);
        
    }
    public int numIslands(char[][] grid) {
        int ccnum = 0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    ccnum ++;
                }
            }
        }
        return ccnum;
    }
}