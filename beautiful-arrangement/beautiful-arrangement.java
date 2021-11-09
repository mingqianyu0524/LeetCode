class Solution {
    int count = 0;
    public int countArrangement(int n) {
        boolean[] visited = new boolean[n+1];
        backtrack(visited, 1, n);
        return count;
    }
    private void backtrack(boolean[] visited, int i, int n) {
        if (i > n) count++;
        for (int j=1;j<=n;j++) {
            if (!visited[j] && (i%j == 0 || j%i==0)) {
                visited[j] = true;
                backtrack(visited, i+1, n);
                visited[j] = false;
            }
        }
    }
}