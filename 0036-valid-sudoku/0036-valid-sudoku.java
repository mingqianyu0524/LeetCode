class Solution {
    public boolean isValidSudoku(char[][] M) {
        int N = 9;
        
        HashSet<Character>[] rows = new HashSet[N];
        HashSet<Character>[] cols = new HashSet[N];
        HashSet<Character>[] boxes = new HashSet[N];
        for (int r = 0; r < N; r++) {
            rows[r] = new HashSet<Character>();
            cols[r] = new HashSet<Character>();
            boxes[r] = new HashSet<Character>();
        }
        
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                char cr = M[r][c];
                int k = 3 * (r/3) + (c/3);
                if (cr != '.') {
                    if (rows[r].contains(cr) || cols[c].contains(cr) || boxes[k].contains(cr)) {
                        return false;
                    }
                    if (!rows[r].contains(cr))
                        rows[r].add(cr);
                    if (!cols[c].contains(cr))
                        cols[c].add(cr);
                    if (!boxes[k].contains(cr))
                        boxes[k].add(cr);
                }
            }
        }
        return true;
    }
}