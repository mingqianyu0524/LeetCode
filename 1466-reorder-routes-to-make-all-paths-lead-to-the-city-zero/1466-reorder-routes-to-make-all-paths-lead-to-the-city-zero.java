class Solution {  
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] connection : connections) {
            int x = connection[0], y = connection[1];
            graph.get(x).add(y);
            graph.get(y).add(-x);
        }
        return dfs(graph, new boolean[n], 0);
    }
    private int dfs(List<List<Integer>> graph, boolean[] visited, int from) {
        int count = 0;
        visited[from] = true;
        for (int to : graph.get(from)) {
            if (!visited[Math.abs(to)]) {
                visited[Math.abs(to)] = true;
                count += dfs(graph, visited, Math.abs(to)) + (to > 0 ? 1 : 0);
            }
        }
        return count;
    }
}