class Solution {
    public void rotate(int[] A, int k) {
        int n = A.length;
        int[] B = new int[n];
        for (int i = 0; i < n; i++) 
            B[k++ % n] = A[i];
        for (int i = 0; i < n; i++)
            A[i] = B[i];
    }
}