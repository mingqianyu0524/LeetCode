class Solution {
    int[][] dirs = new int[][]{{0,-1},{0,1},{-1,0},{1,0}};
    public int minimumEffortPath(int[][] heights) {
        int left = 0;
        int right = 1000000;
        int result = right;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canReachDestinaton(heights, mid)) {
                result = Math.min(result, mid);
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
    private boolean canReachDestinaton(int[][] heights, int k) {
        int m = heights.length, n = heights[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            if (cell[0] == m - 1 && cell[1] == n - 1) return true;
            for (int[] dir : dirs) {
                int x = cell[0] + dir[0], y = cell[1] + dir[1];
                if (isValid(x, y, m, n) && !visited[x][y]) {
                    int diff = Math.abs(heights[x][y] - heights[cell[0]][cell[1]]);
                    if (diff <= k) {
                        visited[x][y] = true;
                        queue.add(new int[]{x, y});
                    }
                }
            }
        }
        return false;
    }
    private boolean isValid(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}