class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                String cur = strs[j];
                if (i == cur.length() || cur.charAt(i) != c) {
                    return prefix.substring(0, i);
                }
            }
        }
        return prefix;
    }
}