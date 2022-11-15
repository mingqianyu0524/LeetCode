class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];
        for (char c : magazine.toCharArray()) {
            arr[c-'a']++;
        }
        for (char d : ransomNote.toCharArray()) {
            if (arr[d-'a'] == 0) return false;
            arr[d-'a']--;
        }
        return true;
    }
}