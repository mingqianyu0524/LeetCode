class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder res = new StringBuilder();
        Set<Character> set = new HashSet<>();
        
        // find the length of the shortest str
        int len = Integer.MAX_VALUE;
        for (String s : strs) {
            len = Math.min(len, s.length());
        }
        int i = 0;
        while (i < len) {
            for (String s : strs) {
                if (set.isEmpty()) {
                    set.add(s.charAt(i));
                }
                if (!set.contains(s.charAt(i))) {
                    return res.toString();
                }
            }
            res.append(set.iterator().next());
            set.clear();
            i++;
        }
        return res.toString();
    }
}