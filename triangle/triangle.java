class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m-1).size();
        int[][] T = new int[m][n];
        for (int i=0; i<n; ++i) {
            T[0][i] = triangle.get(0).get(0);
        }
        for (int i=1; i<m; ++i) {
            for (int j=0; j<triangle.get(i).size(); ++j) {
                if (j==0) T[i][j] = T[i-1][j] + triangle.get(i).get(j);
                else if (j==triangle.get(i).size()-1) T[i][j] = T[i-1][j-1] + triangle.get(i).get(j);
                else T[i][j] = Math.min(T[i-1][j-1], T[i-1][j])+triangle.get(i).get(j);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int k=0; k<n; ++k) {
            if (T[m-1][k] < min) min = T[m-1][k];
        }
        return min;
    }
}