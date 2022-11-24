class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int m = spells.length, n = potions.length;
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            int j = binarySearch(potions, (double) success / spells[i]);
            res[i] = n - j;
        }
        return res;
    }
    public int binarySearch(int[] arr, double target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return left;
    }
}