class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length(), i = 0;
        for (int j = 0; j < n; j++) {
            char c = s.charAt(j);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (i <= j && map.get(s.charAt(i)) > 1) {
                i++;
            }
        }
        return i == n ? -1 : i;
    }
}