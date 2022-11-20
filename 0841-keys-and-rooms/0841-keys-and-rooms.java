class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(0, rooms, visited);
        int count = 0;
        for (int i = 0; i < rooms.size(); i++) {
            count += visited[i]? 1 : 0;
        }
        return count == rooms.size();
    }
    private void dfs(int i, List<List<Integer>> rooms, boolean[] visited) {
        visited[i] = true;
        List<Integer> adj = rooms.get(i);
        for (int j : adj) {
            if (!visited[j]) dfs(j, rooms, visited);
        }
    }
}