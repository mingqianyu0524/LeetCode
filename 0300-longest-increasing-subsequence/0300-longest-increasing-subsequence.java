class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            if (num > sub.get(sub.size() - 1)) {
                sub.add(num);
            } else {
                // binary search
                int j = binarySearch(sub, num);
                sub.set(j, num);
            }
        }
        return sub.size();
    }
    private int binarySearch(ArrayList<Integer> sub, int num) {
        int left = 0;
        int right = sub.size() - 1;
        int mid = (left + right) / 2;
        while (left < right) {
            mid = (left+right)/2;
            if (sub.get(mid) == num) return mid;
            else if (sub.get(mid) < num) left = mid+1;
            else right = mid;
        }
        return left;
    }
}