class Solution {
    public List<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<>();
        int len = s.length();
        for (int i = 1; i < 4 && i < len-2; i++) {
            for (int j = i+1; j < i+4 && j < len-1; j++) {
                for (int k = j+1; k < j+4 && k < len; k++) {
                    String a = s.substring(0, i);
                    String b = s.substring(i, j);
                    String c = s.substring(j, k);
                    String d = s.substring(k, len);
                    if (isValid(a) && isValid(b) && isValid(c) && isValid(d)) {
                        res.add(a + "." + b + "." + c + "." + d);
                    }
                }
            }
        }
        return res;
    }
    private boolean isValid(String s) {
        if (    s.length() > 3 
            ||  s.length() == 0 
            ||  s.charAt(0) == '0' && s.length() > 1
            ||  Integer.parseInt(s) > 255) {
            return false;
        }
        return true;
    }
}