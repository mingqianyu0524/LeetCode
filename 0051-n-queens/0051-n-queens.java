class Solution {
    private int size;
    private List<List<String>> solutions = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        size = n;
        char emptyBoard[][] = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                emptyBoard[i][j] = '.';
            }
        }
        backtrack(0, new HashSet<>(), new HashSet<>(), new HashSet<>(), emptyBoard);
        return solutions;
    }
    private List<String> createBoard(char[][] state) {
        List<String> board = new ArrayList<>();
        for (int r = 0; r < size; r++) {
            board.add(new String(state[r]));
        }
        return board;
    }
    private void backtrack(int row, Set<Integer> diagonals, Set<Integer> antidiagonals, Set<Integer> cols, char[][] state) {
        if (row == size) {
            solutions.add(createBoard(state));
            return;
        }
        for (int col = 0; col < size; col++) {
            int diagonal = row - col;
            int antidiagonal = row + col;
            if (cols.contains(col) || diagonals.contains(diagonal) || antidiagonals.contains(antidiagonal)) {
                continue;
            }
            cols.add(col);
            diagonals.add(diagonal);
            antidiagonals.add(antidiagonal);
            state[row][col] = 'Q';
            backtrack(row+1, diagonals, antidiagonals, cols, state);
            
            cols.remove(col);
            diagonals.remove(diagonal);
            antidiagonals.remove(antidiagonal);
            state[row][col] = '.';
        }
    }
}