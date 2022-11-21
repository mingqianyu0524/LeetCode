class Solution {
    class State {
        int row;
        int col;
        int step;
        State(int row, int col, int step) {
            this.row = row;
            this.col = col;
            this.step = step;
        }
    }
    
    private static final int[][] dirs = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}, {-1,-1},{-1,1}, {1,-1}, {1,1}};
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) return -1;
        
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        
        Queue<State> queue = new LinkedList<>();
        visited[0][0] = true;
        queue.add(new State(0, 0, 1));
        
        while (!queue.isEmpty()) {
            // get current state
            State state = queue.poll();
            int row = state.row, col = state.col, step = state.step;
            // returns when row and col == n-1
            if (row == n-1 && col == n-1) {
                return step;
            }
            // traverse the graph in 8 directions
            for (int dir[] : dirs) {
                int nextRow = row + dir[0], nextCol = col + dir[1];
                if (isValid(grid, nextRow, nextCol, n) && !visited[nextRow][nextCol]) {
                    // critical!
                    visited[nextRow][nextCol] = true;
                    queue.add(new State(nextRow, nextCol, step + 1));
                }
            }
        }
        return -1;
    }
    
    private boolean isValid(int[][] grid, int r, int c, int n) {
        return (r >= 0 && r < n && c >= 0 && c < n && grid[r][c] == 0);
    }
}