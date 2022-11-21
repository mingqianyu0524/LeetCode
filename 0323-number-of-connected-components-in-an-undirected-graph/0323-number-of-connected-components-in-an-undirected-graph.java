class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
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
    private void dfs(int v, boolean[] visited, Map<Integer, List<Integer>> adj) {
        visited[v] = true;
        for (int w : adj.get(v)) {
            if (!visited[w]) dfs(w, visited, adj);
        }
        return;
    } 
}