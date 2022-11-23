class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int a : arr) {
            cnt.put(a, cnt.getOrDefault(a, 0) + 1);
        }
        
        PriorityQueue<Integer> heap = new PriorityQueue<>(cnt.values());
        while (k > 0) {
            int f = heap.peek();
            if (f <= k) {
                k -= f;
                heap.remove();
            } else break;
        }
        return heap.size();
    }
}