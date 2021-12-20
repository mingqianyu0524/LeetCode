class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        for (int x : nums) map.put(x, true);
        List<Integer> res = new LinkedList<>();
        for (int i=1; i<=n; ++i) {
            if (!map.containsKey(i)) res.add(i);
        }
        return res;
    }
}