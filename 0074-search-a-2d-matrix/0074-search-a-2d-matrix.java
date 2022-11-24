class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int l = 0, r = m - 1;
        while (l <= r) {
            int mid = l + (r - l)/2;
            if (matrix[mid][0] <= target && matrix[mid][n-1] >= target) {
                l = 0;
                r = n - 1;
                int i = mid;
                while (l <= r) {
                    mid = l + (r - l)/2;
                    if (matrix[i][mid] == target) return true;
                    else if (matrix[i][mid] > target) r = mid - 1;
                    else l = mid + 1;
                }
                return false;
            }
            if (matrix[mid][0] > target) {
                r = mid - 1;
            }
            if (matrix[mid][n-1] < target) {
                l = mid + 1;
            }
        }
        return false;
    }
}