class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (need.containsKey(c)) {
                need.replace(c, need.get(c)+1);
            } else {
                need.put(c, 1);
            }
        }
        
        int l = 0, r = 0, valid = 0;
        int start = 0, len = Integer.MAX_VALUE;
        
        while (r < s.length()) {
            char c = s.charAt(r);
            r++;
            
            if (need.containsKey(c)) {
                // update window
                if (window.containsKey(c)) {
                    window.put(c, window.get(c)+1);
                } else {
                    window.put(c, 1);
                }
                
                // increment valid when matches characters in string t
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            
            while (l < r && valid == need.size()) {
                // update result
                if (r - l < len) {
                    start = l;
                    len = r-l;
                }
                
                char d = s.charAt(l);
                l++;
                
                if (need.containsKey(d)) {
                    // decrement valid when matches cahracters in string t
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    // update window
                    if (window.containsKey(d)) {
                        window.replace(d, window.get(d)-1);
                    }
                }
            }
        }
        
        return len == Integer.MAX_VALUE? "": s.substring(start, start+len);
    }
}