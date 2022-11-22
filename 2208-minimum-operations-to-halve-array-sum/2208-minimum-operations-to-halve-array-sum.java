class Solution {
    public int halveArray(int[] nums) {
        double sum = 0, target = 0;
        for (int num : nums) {
            sum += num;
        }
        int count = 0;
        PriorityQueue<Double> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums) {
            heap.add((double)num);
        }
        while (target < sum / 2) {
            double max = heap.remove();
            target += max/2;
            heap.add(max/2);
            count++;
        }
        return count;
    }
}