class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int a : arr) {
            cnt.put(a, cnt.getOrDefault(a, 0) + 1);
        }
        
        LinkedList<Integer> freq = new LinkedList<>();
        for (int val : cnt.values()) {
            freq.add(val);
        }
        Collections.sort(freq);
        System.out.printf("num of unique numbers before removal: %d\n", freq.size());
            
        while (k > 0) {
            int f = freq.getFirst();
            if (f <= k) {
                k -= f;
                freq.removeFirst();
            } else break;
        }
        System.out.printf("num of unique numbers after removal: %d\n", freq.size());
        return freq.size();
    }
}