class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int stick : sticks) heap.add(stick);
        int cost = 0;
        while (heap.size() > 1) {
            int first = heap.remove();
            int second = heap.remove();
            cost += (first + second);
            heap.add(first + second);
        }
        return cost;
    }
}