class Solution {
    int n = 3, N = 9;

    int [][] rows = new int[N][N + 1];
    int [][] cols = new int[N][N + 1];
    int [][] boxes = new int[N][N + 1];

    char[][] M;
    boolean sudokuSolved = false;
    
    private boolean isValid(int d, int r, int c) {
        int idx = n*(r/n) + c/n;
        return rows[r][d] + cols[c][d] + boxes[idx][d] == 0;
    }
    
    private void placeNumber(int d, int r, int c) {
        int idx = n*(r/n) + c/n;
        rows[r][d]++;
        cols[c][d]++;
        boxes[idx][d]++;
        M[r][c] = (char)(d+'0');
    }
    
    private void removeNumber(int d, int r, int c) {
        int idx = n*(r/n) + c/n;
        rows[r][d]--;
        cols[c][d]--;
        boxes[idx][d]--;
        M[r][c] = '.';
    }
    
    private void placeNextNumber(int r, int c) {
        if (r == N - 1 && c == N - 1)
            sudokuSolved = true;
        else {
            if (c == N - 1) backtrack(r+1, 0);
            else backtrack(r, c+1);
        }
    }
    
    private void backtrack(int r, int c) {
        if (M[r][c] == '.') {
            for (int d = 1; d < 10; d++) {
                if (isValid(d, r, c)) {
                    placeNumber(d, r, c);
                    placeNextNumber(r, c);
                    if (!sudokuSolved) removeNumber(d, r, c);
                }
            }
        } else {
            placeNextNumber(r, c);
        }
    }
    
    public void solveSudoku(char[][] board) {
        this.M = board;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int d = Character.getNumericValue(c);
                    placeNumber(d, i, j);
                }
            }
        }
        backtrack(0, 0);
    }
}