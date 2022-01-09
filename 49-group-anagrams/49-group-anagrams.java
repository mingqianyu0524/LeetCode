class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List> ans = new HashMap<>();
        int[] counter = new int[26];
        for (String s : strs) {
            Arrays.fill(counter, 0);
            for (char c : s.toCharArray()) counter[c-'a']++;
            
            // int arr -> sb -> str, somehow int arr doesn't work, find out why!
            StringBuilder sb = new StringBuilder("");
            for (int i=0; i<26; i++) {
                sb.append('#');
                sb.append(counter[i]);
            }
            String key = sb.toString();
            
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
}