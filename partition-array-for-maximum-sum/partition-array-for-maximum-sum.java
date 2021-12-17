class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        // base case: dp 0->k-1
        int max = 0;
        for (int i=0; i<k; ++i) {
            max = Math.max(arr[i], max);
            dp[i] = max*(i+1);
        }
        // dp k->n-1
        for (int i=k; i<n; ++i) {
            int s = 0;
            for (int j=1; j<=k; ++j) {
                s = Math.max(s, arr[i-j+1]);
                dp[i] = Math.max(dp[i], dp[i-j] + j*s);
            }
        }
        return dp[n-1];
    }
}