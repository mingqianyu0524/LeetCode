class Solution {
public int mySqrt(int x) {
        int left = 1, right = x, mid = x;
        while (left <= right) {
            mid = left + (right-left)/2;
            long num = (long)mid*mid;
            if (num == x) return mid;
            else if (num < x) {
                left = mid+1;
            }
            else {
                right = mid-1;
            }
        }
        return (int)right;
    }
}