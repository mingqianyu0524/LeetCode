class Solution {
    public boolean areOccurrencesEqual(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        for (char c : s.toCharArray()) {
            count = map.getOrDefault(c, 0) + 1;
            map.put(c, count);
        }
        Set<Integer> set = new HashSet<>(map.values());
        return set.size() == 1;
    }
}