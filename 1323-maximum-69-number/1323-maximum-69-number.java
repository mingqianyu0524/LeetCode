class Solution {
    public int maximum69Number (int num) {
        String s = Integer.toString(num);
        StringBuilder sb = new StringBuilder();
        boolean flipped = false;
        for (char c : s.toCharArray()) {
            if (c == '6' && !flipped) {
                c = '9';
                flipped = true;
            }
            sb.append(c);
        }
        return Integer.parseInt(sb.toString());
    }
}