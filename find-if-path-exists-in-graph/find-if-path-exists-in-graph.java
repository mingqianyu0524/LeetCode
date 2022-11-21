class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(i, new ArrayList<Integer>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        return dfs(source, destination, new boolean[n], adj);
    }
    private boolean dfs(int s, int t, boolean[] visited, List<List<Integer>> adj) {
        if (s == t) return true;
        visited[s] = true;
        for (int v : adj.get(s)) {
            if (!visited[v]) {
                boolean res = dfs(v, t, visited, adj);
                if (!res) continue; 
                else return res;
            }
            
        }
        return false;
    }
}