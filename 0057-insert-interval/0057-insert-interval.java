class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> res = new LinkedList<>();
        int i = 0, n = intervals.length;
        while (i < n && newInterval[0] > intervals[i][0]) 
            res.add(intervals[i++]);
        if (res.isEmpty() || res.getLast()[1] < newInterval[0])
            res.add(newInterval);
        else
            res.getLast()[1] = Math.max(res.getLast()[1], newInterval[1]);
        while (i < n) {
            if (res.getLast()[1] < intervals[i][0])
                res.add(intervals[i]);
            else
                res.getLast()[1] = Math.max(res.getLast()[1], intervals[i][1]);
            i++;
        }
        return res.toArray(new int[res.size()][]);
    }
}