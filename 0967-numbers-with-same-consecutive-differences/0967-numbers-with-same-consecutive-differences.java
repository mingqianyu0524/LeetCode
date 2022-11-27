class Solution {
    List<Integer> res;
    
    public int[] numsSameConsecDiff(int n, int k) {
        res = new ArrayList<>();
        for (int i = 1; i < 10; i++)
            backtrack(i, n - 1, k);
        return res.stream().mapToInt(i->i).toArray();
    }
    private void backtrack(int num, int n, int k) {
        if (n == 0) res.add(num);
        else {
            int dig = num % 10;
            if (dig + k < 10) 
                backtrack(num * 10 + dig + k, n - 1, k);
            if (k != 0 && dig >= k)
                backtrack(num * 10 + dig - k, n - 1, k);
        }
    }
}