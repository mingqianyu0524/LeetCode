class Solution {
    enum Result {TRUE, FALSE}
    private Result[][] cache;
    public boolean isMatch(String s, String p) {
        cache = new Result[s.length()+1][p.length()+1];
        return dfs(s, p, 0, 0);
    }
    private boolean dfs(String s, String p, int i, int j) {
        if (cache[i][j] != null) {
            return cache[i][j] == Result.TRUE;
        }
        if (i >= s.length() && j >= p.length()) {
            return true;
        }
        if (j >= p.length()) {
            return false;
        }
        boolean ans;
        boolean match = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        if (j + 1 < p.length() && p.charAt(j+1) == '*') {
            ans = dfs(s, p, i, j+2) || (match && dfs(s, p, i+1, j));
        }
        else if (match) {
            ans = dfs(s, p, i+1, j+1);
        } else {
            ans = false;
        }
        cache[i][j] = ans ? Result.TRUE : Result.FALSE;
        return ans;
    }
}