class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(
            (a, b) -> (b[1] - a[1])
        );
        heap.addAll(Arrays.asList(boxTypes));
        
        int count = 0;
        while (truckSize > 0 && !heap.isEmpty()) {
            int[] box = heap.remove();
            if (box[0] <= truckSize) {
                count += box[0] * box[1];
                truckSize -= box[0];
            }
            else {
                count += truckSize * box[1];
                truckSize = 0;
            }
        }
        return count;
    }
}