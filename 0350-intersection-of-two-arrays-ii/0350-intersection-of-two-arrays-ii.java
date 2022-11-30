class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int l = 0, r = 0, k = 0;
        while (l < nums1.length && r < nums2.length) {
            if (nums1[l] < nums2[r]) l++;
            else if (nums1[l] > nums2[r]) r++;
            else {
                nums1[k++] = nums1[l++];
                r++;
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }
}