class Solution {
    public int mySqrt(int x) {
        long start =0;
        long end = x/2;
        long ans = 0;

        if(x == 0 || x == 1)
            return x;
        while(start <= end)
        {
           long  mid = (start + end) / 2;
            if(mid * mid == x)
            {
                return (int)mid;
            }
            if(mid * mid < x)
            {
                start = mid + 1;
                ans = mid;
            }
            else
            {
                end = mid - 1;
            }
        }
        return (int)ans;
    }
}