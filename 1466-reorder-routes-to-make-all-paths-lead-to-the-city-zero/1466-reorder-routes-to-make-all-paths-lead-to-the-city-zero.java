class Solution {
    private Map<Integer, List<Integer>> graph = new HashMap<>();
    private boolean[] visited;
    
    public int minReorder(int n, int[][] connections) {
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        visited = new boolean[n];
        for (int[] connection : connections) {
            int x = connection[0], y = connection[1];
            graph.get(x).add(y);
            graph.get(y).add(-x);
        }
        visited[0] = true;
        return dfs(0);
    }
    private int dfs(int m) {
        int count = 0;
        for (int n : graph.get(m)) {
            if (!visited[Math.abs(n)]) {
                if (n >= 0) {
                    count++;
                }
                visited[Math.abs(n)] = true;
                count += dfs(Math.abs(n));
            }
        }
        return count;
    }
    private String convertToHash(int x, int y) {
        return String.valueOf(x) + "," + String.valueOf(y);
    }
}