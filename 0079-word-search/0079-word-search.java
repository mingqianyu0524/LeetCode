class Solution {
    private int[][] dirs = new int[][]{{0,-1},{0,1},{-1,0},{1,0}};
    
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == word.charAt(0)) {
                    boolean res = backtrack(board, word, 1, r, c);
                    if (res) return true;
                }
            }
        }
        return false;
    }
    private boolean backtrack(char[][] M, String word, int i, int r, int c) {
        if (i >= word.length()) return true;
        for (int[] dir : dirs) {
            int nr = r + dir[0], nc = c + dir[1];
            if (valid(nr, nc, M.length, M[0].length) && M[nr][nc] == word.charAt(i)) {
                char entry = M[r][c];
                M[r][c] = '0';
                boolean res = backtrack(M, word, i+1, nr, nc);
                M[r][c] = entry;
                if (res) return true;
            }
        }
        return false;
    }
    
    private boolean valid(int r, int c, int m, int n) {
        return r >= 0 && r < m && c >= 0 && c < n;
    }
}