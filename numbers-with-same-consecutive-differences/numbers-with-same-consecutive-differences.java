class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < 10; i++)
            backtrack(res, i, n - 1, k);
        return res.stream().mapToInt(i->i).toArray();
    }
    private void backtrack(List<Integer> res, int num, int n, int k) {
        if (n == 0) res.add(num);
        else {
            int dig = num % 10;
            if (dig + k < 10) 
                backtrack(res, num * 10 + dig + k, n - 1, k);
            if (k != 0 && dig >= k)
                backtrack(res, num * 10 + dig - k, n - 1, k);
        }
    }
}