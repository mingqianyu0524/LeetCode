class Solution {
    public int explore(int[][] grid, int i, int j, int currArea) {
        int m = grid.length;
        int n = grid[0].length;
        if (i>=0 && j>=0 && i<m && j<n && grid[i][j] == 1) {
            grid[i][j] = 0;
            currArea ++;
            currArea = explore(grid, i+1, j, currArea);
            currArea = explore(grid, i-1, j, currArea);
            currArea = explore(grid, i, j+1, currArea);
            currArea = explore(grid, i, j-1, currArea);
        }
        return currArea;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxSoFar = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 1) {
                    int currMax = explore(grid, i, j, 0);
                    if (currMax > maxSoFar) {
                        maxSoFar = currMax;
                    }
                }    
            }            
        }
        return maxSoFar;
    }
}