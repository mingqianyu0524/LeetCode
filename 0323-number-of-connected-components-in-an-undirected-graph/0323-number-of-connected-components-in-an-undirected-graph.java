class Solution {
    public int countComponents(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, visited, graph);
                count++;
            }
        }
        return count;
    }
    private void dfs(int v, boolean[] visited, List<Integer>[] adj) {
        visited[v] = true;
        for (int w : adj[v]) {
            if (!visited[w]) dfs(w, visited, adj);
        }
        return;
    } 
}