class Solution {
    public int firstUniqChar(String s) {
        int[] freq = new int[26];
        int n = s.length(), i = 0;
        for (int j = 0; j < n; j++) {
            char c = s.charAt(j);
            freq[c - 'a'] ++;
            while (i <= j && freq[s.charAt(i)-'a'] > 1) {
                i++;
            }
        }
        return i == n ? -1 : i;
    }
}