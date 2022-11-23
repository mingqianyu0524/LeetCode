class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((p1,p2)->(
            p2[0]*p2[0] + p2[1]*p2[1] - p1[0]*p1[0] - p1[1]*p1[1]
        ));
        for (int[] point : points) {
            heap.add(point);
            if (heap.size() > k) heap.remove();
        }
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            res[i] = (heap.remove());
        }
        return res;
    }
}