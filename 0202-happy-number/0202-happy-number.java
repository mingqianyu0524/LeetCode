class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            int sum = 0;
            while (n > 0) {
                int m = n % 10;
                sum += m*m;
                n = n / 10;
            }
            if (!set.contains(sum)) {
                set.add(sum);
                n = sum;
            } else {
                return false;
            }
        }
        return true;
    }
}