class Solution {
    public boolean checkIfPangram(String sentence) {
        Map<Character, Boolean> found = new HashMap<>();
        for (int i = 0; i < sentence.length(); i++) {
            if (!found.containsKey(sentence.charAt(i))) {
                found.put(sentence.charAt(i), true);
            }
        }
        return found.size() < 26? false: true;
    }
}