class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1)
            map.put(num, map.getOrDefault(num, 0) + 1);
        int j = 0, k = 0;
        for (int num : nums2) {
            if (j < nums1.length && map.containsKey(num) && map.get(num) > 0) {
                nums1[j] = num;
                map.put(nums1[j++], map.get(num) - 1);
                k++;
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }
}