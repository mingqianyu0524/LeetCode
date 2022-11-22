class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> cnt = new HashMap<>();
        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> heap = new PriorityQueue<>(
                (w1, w2) -> 
            cnt.get(w1).equals(cnt.get(w2)) ? w2.compareTo(w1) : cnt.get(w1) - cnt.get(w2));
        for (String word : cnt.keySet()) {
            heap.add(word);
            if (heap.size() > k) heap.remove();
        }
        List<String> res = new ArrayList<>();
        while (!heap.isEmpty()) {
            res.add(heap.remove());
        }
        Collections.reverse(res);
        return res;
    }
}