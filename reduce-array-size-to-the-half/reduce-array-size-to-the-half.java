class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int val : map.values()) heap.add(val);
        
        int n = arr.length, ans = 0, T = 0;
        while (T < n/2) {
            T += heap.poll();
            ans++;
        }
        return ans;
    }
}