class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] copy = new int[m];
        for (int i = 0; i < m; i++) {
            copy[i] = nums1[i];
        }
        int p1 = 0, p2 = 0;
        for (int p = 0; p < m+n; p++) {
            if (p2 >= n || p1 < m && copy[p1] < nums2[p2]) {
                nums1[p] = copy[p1++];
            } else {
                nums1[p] = nums2[p2++];
            }
        }
    }
}