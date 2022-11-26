class Solution {
    int ans;
    public int totalNQueens(int n) {
        ans = 0;
        Set<Integer> cols = new HashSet<Integer>();
        Set<Integer> diagonals = new HashSet<Integer>();
        Set<Integer> antidiagonals = new HashSet<Integer>();
        backtrack(n, 0, cols, diagonals, antidiagonals);
        return ans;
    }
    
    private void backtrack(int n, int r, Set<Integer> cols, Set<Integer> diagonals, Set<Integer> antidiagonals) {
        if (r == n) ans++;
        for (int c = 0; c < n; c++) {
            if (!cols.contains(c) && !diagonals.contains(r-c) && !antidiagonals.contains(r+c)) {
                cols.add(c);
                diagonals.add(r-c);
                antidiagonals.add(r+c);
                backtrack(n, r+1, cols, diagonals, antidiagonals);
                cols.remove(c);
                diagonals.remove(r-c);
                antidiagonals.remove(r+c);
            }
        }
    }
}