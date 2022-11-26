class Solution {
    List<String> res;
    Map<Character, String> map;
    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        map = Map.of('2',"abc", '3', "def",'4', "ghi", '5', "jkl",'6', 
                     "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
        if (digits.length() == 0) return res;
        backtrack(digits, new StringBuilder(), 0);
        return res;
    }
    
    private void backtrack(String s, StringBuilder curr, int i) {
        if (i >= s.length()) {
            res.add(curr.toString());
            return;
        }
        String alphabets = map.get(s.charAt(i));
        for (char c : alphabets.toCharArray()) {
            curr.append(c);
            backtrack(s, curr, i+1);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}