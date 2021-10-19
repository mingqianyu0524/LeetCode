class Solution {
    private int count = 0;
    private int[] visited = new int[200];
    
    private void dfs(int[][] M, int i) {
        visited[i] = 1;
        for (int j=0; j<M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                dfs(M, j);
            }
        }
    }
    public int findCircleNum(int[][] M) {
        for (int i=0; i<M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, i);
                count++;
            }                    
        }
        return count;
    }
}