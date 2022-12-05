/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        return binarySearch(1, n);
        
    }
    private int binarySearch(int l, int r) {
        if (l >= r) return l;
        int mid = l + (r-l)/2;   
        if (!isBadVersion(mid))
            return binarySearch(mid+1, r);
        else
            return binarySearch(l, mid);
    }
}