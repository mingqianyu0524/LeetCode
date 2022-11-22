class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int lo = 0;
		int hi = arr.length - 1;
        while (hi - lo >= k) {
            if (Math.abs(arr[lo] - x) <= Math.abs(arr[hi] - x)) {
                hi--;
            } else {
                lo++;
            }
        }
        List<Integer> res = new LinkedList<>();
        for (int i = lo; i <= hi; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}