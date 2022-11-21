class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        Set<Integer> set = new HashSet<>();
        for (int j = 0; j < restricted.length; j++) {
            set.add(restricted[j]);
        }
        // convert G -> G' by removing edges containing restricted vertices
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1];
            if (!set.contains(from) && !set.contains(to)) {
                adj[from].add(to);
                adj[to].add(from);
            }
        }
        // dfs
        boolean[] visited = new boolean[n];
        return dfs(adj, 0, visited, 0);
    }
    
    private int dfs(List<Integer>[] adj, int v, boolean[] visited, int count) {
        visited[v] = true;
        for (int w : adj[v]) {
            if (!visited[w]) {
                count += dfs(adj, w, visited, 0);
            }
        }
        return ++count;
    }
}