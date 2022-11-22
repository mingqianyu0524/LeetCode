class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        Queue<int[]> queue = new LinkedList<>();
        // add 0 cells as starting points into the queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) queue.add(new int[]{i, j});
                else mat[i][j] = -1;
            }
        }
        
        // BFS
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1];
            for (int[] dir : dirs) {
                int nr = r + dir[0], nc = c + dir[1];
                if (nr < 0 || nr == m || nc < 0 || nc == n || mat[nr][nc] != -1) 
                    continue;
                mat[nr][nc] = mat[r][c] + 1; // inplace modification
                queue.add(new int[]{nr, nc});
            }
        }
        return mat;
    }
}