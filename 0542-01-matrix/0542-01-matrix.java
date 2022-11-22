class Solution {
    class State {
        int row; int col; int step;
        State(int row, int col, int step) {
            this.row = row;
            this.col = col;
            this.step = step;
        }
    }
    
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        
        Queue<State> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        
        // add 0 cells as starting points into the queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new State(i, j, 1));
                    visited[i][j] = true;
                }
            }
        }
        
        // bfs
        while (!queue.isEmpty()) {
            State state = queue.poll();
            int r = state.row, c = state.col, step = state.step;
            for (int[] dir : dirs) {
                int nr = r + dir[0], nc = c + dir[1];
                if (isValid(mat, nr, nc) && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.add(new State(nr, nc, step + 1));
                    mat[nr][nc] = step; // inplace modification
                }
            }
        }
        return mat;
    }
    
    private boolean isValid(int[][] mat, int i, int j) {
        int m = mat.length, n = mat[0].length;
        return i >= 0 && i < m && j >= 0 && j < n && mat[i][j] == 1;
    }
}