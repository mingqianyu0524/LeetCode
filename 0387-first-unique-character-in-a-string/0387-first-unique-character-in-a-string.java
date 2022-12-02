class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int i = 0;
        while (map.get(s.charAt(i)) > 1) {
            if (++i == s.length()) break;
        }
        return i == s.length() ? -1 : i;
    }
}