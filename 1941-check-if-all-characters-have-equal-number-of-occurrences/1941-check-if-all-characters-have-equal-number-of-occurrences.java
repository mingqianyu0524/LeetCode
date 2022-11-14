class Solution {
    public boolean areOccurrencesEqual(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count = map.getOrDefault(c, 0) + 1;
            map.put(c, count);
        }
        for (char c : map.keySet()) {
            if (map.get(c) != count) return false;
            System.out.printf("key: %s, value: %d\n", c, map.get(c));
        }
        return true;
    }
}