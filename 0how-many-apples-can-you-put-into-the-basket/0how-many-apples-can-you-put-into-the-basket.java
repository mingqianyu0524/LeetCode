class Solution {
    public int maxNumberOfApples(int[] weight) {
        Arrays.sort(weight);
        int count = 0, T = 5000;
        for (int w : weight) {
            if (T >= w) {
                T -= w;
                count++;
            } else break;
        }
        return count;
    }
}