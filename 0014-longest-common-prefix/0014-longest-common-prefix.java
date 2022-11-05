class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder res = new StringBuilder();
        // find the length of the shortest str
        int len = Integer.MAX_VALUE;
        for (String s : strs) {
            len = Math.min(len, s.length());
        }
        int i = 0;
        Character cur = new Character('A');
        while (i < len) {
            for (String s : strs) {
                if (cur.equals('A')) {
                    cur = s.charAt(i);
                }
                if (!cur.equals(s.charAt(i))) {
                    return res.toString();
                }
            }
            res.append(cur);
            cur = new Character('A');
            i++;
        }
        return res.toString();
    }
}