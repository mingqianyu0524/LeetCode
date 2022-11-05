class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder[] sbList = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sbList[i] = new StringBuilder();
        }
        int n = s.length();
        int dir = 0;
        for (int i = 0, j = 0; i < n; i++) {
            char c = s.charAt(i);
            if (dir == 0) {
                boolean reverse = j >= numRows - 1;
                if (reverse) dir = 1;
                sbList[j].append(c);
                j = reverse? j-1 : j+1;
            } else {
                boolean reverse = j <= 0;
                if (reverse) dir = 0;
                sbList[j].append(c);
                j = reverse? j+1 : j-1;
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            res.append(sbList[i].toString());
        }
        return res.toString();
    }
}