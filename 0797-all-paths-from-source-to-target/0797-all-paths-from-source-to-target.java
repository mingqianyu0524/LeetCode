class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        res = new ArrayList<>();
        List<Integer> curr = new ArrayList<Integer>();
        curr.add(0);
        backtrack(graph, curr, 0);
        return res;
    }
    
    private void backtrack(int[][] G, List<Integer> curr, int i) {
        if (i == G.length - 1) res.add(new ArrayList<Integer>(curr));
        for (int j = 0; j < G[i].length; j++) {
            curr.add(G[i][j]);
            backtrack(G, curr, G[i][j]);
            curr.remove(curr.size() - 1);
        }
    }
}