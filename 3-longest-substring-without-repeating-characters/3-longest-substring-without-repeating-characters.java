class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] last = new int[128];
        Arrays.fill(last, -1);
        int n = s.length();
        int start = 0, ans = 0;
        for (int i=0; i<n; ++i) {
            start = Math.max(start, last[s.charAt(i)] + 1);
            last[s.charAt(i)] = i;
            ans = Math.max(ans, i - start + 1);
        }
        return ans;
    }
}