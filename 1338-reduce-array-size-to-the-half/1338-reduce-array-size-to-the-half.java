class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        List<Integer> inOrder = new ArrayList<>();
        for (int val : map.values()) {
            inOrder.add(val);
            System.out.printf(val + ",");
        }
        Collections.sort(inOrder, Comparator.reverseOrder());
        int n = arr.length, ans = 0, T = 0;
        for (int x : inOrder) {
            if (T >= n/2) break;
            T += x;
            ans++;
        }
        return ans;
    }
}