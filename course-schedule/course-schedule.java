class Solution {
    public boolean canFinish(int numCourses, int[][] prereq) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[numCourses];
        for (int i=0; i<prereq.length; i++) {
            int pre = prereq[i][1];
            int course = prereq[i][0];
            inDegree[course]++;
            if (graph.containsKey(pre)) {
                graph.get(pre).add(course);
            }
            else {
                List<Integer> list = new ArrayList<>();
                list.add(course);
                graph.put(pre, list);
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i=0; i<numCourses; i++) {
            if (inDegree[i] == 0) q.add(i);
        }
        while (!q.isEmpty()) {
            int curr = q.poll();
            List<Integer> toTake = graph.get(curr);
            for (int i=0; toTake != null && i<toTake.size(); i++) {
                inDegree[toTake.get(i)]--;
                if (inDegree[toTake.get(i)] == 0) {
                    q.add(toTake.get(i));
                }
            } 
        }
        for (int i=0; i<numCourses; i++) {
            if (inDegree[i] != 0) return false;
        }
        return true;
    }
}