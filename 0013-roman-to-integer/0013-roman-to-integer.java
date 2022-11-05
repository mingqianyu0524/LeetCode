class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int res = 0;
        if (s.length() == 1) {
            return map.get(s.charAt(0));
        }
        for (int i = 1; i < s.length(); i++) {
            char cur = s.charAt(i);
            char prev = s.charAt(i-1);
            
            if (i == 1) {
                res += map.get(prev);
            }
            if (map.get(prev) < map.get(cur)) {
                res += map.get(cur) - 2 * map.get(prev);
            } else {
                res += map.get(cur);
            }
        }
        return res;
    }
}