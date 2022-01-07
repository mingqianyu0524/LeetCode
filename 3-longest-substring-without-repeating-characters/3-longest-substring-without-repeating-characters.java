class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int n = s.length();
        for (int i=0; i<n; ++i) {
            int[] seen = new int[128];
            int j=i;
            while (j<n && seen[s.charAt(j)]<1) {
                seen[s.charAt(j++)]++;
            }
            ans = Math.max(ans, j-i);
        }
        return ans;
    }
}