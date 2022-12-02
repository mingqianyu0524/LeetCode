class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        char[] c = s.toCharArray();
        while (i < j) {
            while (!Character.isLetterOrDigit(c[i]))
                if (++i >= s.length()) return true;
            while (!Character.isLetterOrDigit(c[j])) {
                if (--j < 0) return true;
            }
            if (Character.toLowerCase(c[i++]) != Character.toLowerCase(c[j--]))
                return false;
        }
        return true;
    }
}