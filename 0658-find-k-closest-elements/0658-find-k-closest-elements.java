class Solution {
    public List<Integer> findClosestElements(int[] nums, int k, int x) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(
            (n1, n2) -> {
                if (Math.abs(n1 - x) == Math.abs(n2 - x)) {
                    return n2 - n1;
                }
                return Math.abs(n2 - x) - Math.abs(n1 - x);
            }
        );
        for (int num : nums) {
            heap.add(num);
            if (heap.size() > k) {
                heap.remove();
            }
        }
        List<Integer> ans = new LinkedList<>();
        for (int num : heap) {
            ans.add(num);
        }
        Collections.sort(ans);
        return ans;
    }
}