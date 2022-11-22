class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone : piles) heap.add(stone);
        for (int i = 0; i < k; i++) {
            int max = heap.remove();
            int remain = max - max/2;
            heap.add(remain);
        }
        int sum = 0;
        for (int stone : heap) {
            sum += stone;
        }
        return sum;
    }
}