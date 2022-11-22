class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        
        // add 0 cells as starting points into the queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        
        // bfs
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1];
            for (int[] dir : dirs) {
                int nr = r + dir[0], nc = c + dir[1];
                if (isValid(mat, nr, nc) && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.add(new int[]{nr, nc});
                    mat[nr][nc] = mat[r][c] + 1; // inplace modification
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