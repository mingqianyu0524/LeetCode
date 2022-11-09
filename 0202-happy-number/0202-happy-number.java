class Solution {
    private int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int m = n % 10;
            sum += m*m;
            n = n / 10;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNext(n);
        }
        return n == 1;
    }
}