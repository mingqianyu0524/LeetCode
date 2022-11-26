class Solution {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        backtrack(new StringBuilder(), n, 0, 0);        
        return res;
    }
    private void backtrack(StringBuilder curr, int n, int L, int R) {
        if (L == R && L == n) res.add(curr.toString());
        if (L < n) {
            curr.append("(");
            backtrack(curr, n, L+1, R);
            curr.deleteCharAt(curr.length()-1);
        }
        if (R < L) {
            curr.append(")");
            backtrack(curr, n, L, R+1);
            curr.deleteCharAt(curr.length()-1);
        }
        
    }
}