class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int[] arr = new int[58];
        for (char c : stones.toCharArray()) {
            arr[c-'A']++;
        }
        int count = 0;
        for (char d : jewels.toCharArray()) {
            count += arr[d-'A'];
        }
        return count;
    }
}