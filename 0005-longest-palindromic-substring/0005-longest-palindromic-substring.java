class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int len = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            int cur = Math.max(getLen(s, i, i), getLen(s, i, i+1));
            if (cur > len) {
                len = cur;
                start = i - (len - 1) / 2;
            }
        }
        return s.substring(start, start+len);
    }
    private int getLen(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            --l;
            ++r;
        }
        return r - l -1;
    }
}