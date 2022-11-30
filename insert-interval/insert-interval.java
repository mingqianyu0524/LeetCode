class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> res = new LinkedList<>();
        int i = 0, n = intervals.length;
        // add all intervals prior to new
        while (i < n && newInterval[0] > intervals[i][0]) 
            res.add(intervals[i++]);
        // add new interval
        if (res.isEmpty() || res.getLast()[1] < newInterval[0])
            res.add(newInterval);
        else
            res.getLast()[1] = Math.max(res.getLast()[1], newInterval[1]);
        // add all intervals after new
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