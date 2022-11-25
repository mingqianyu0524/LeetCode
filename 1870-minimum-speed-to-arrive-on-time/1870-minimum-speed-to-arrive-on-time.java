class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        if (dist.length > Math.ceil(hour)) {
            return -1;
        }
        
        int l = 1, r = (int) Math.pow(10, 7);
        while (l < r) {
            int v = l + (r - l) / 2;
            if (valid(dist, v, hour)) {
                r = v;
            } else {
                l = v + 1;
            }
        }
        return l;
    }
    
    private boolean valid(int[] dist, int v, double hour) {
        double T = 0;
        for (int i = 0; i < dist.length; i++) {
            double d = Math.ceil((double)dist[i]/(double)v);
            T += i == dist.length - 1 ? (double)dist[i]/(double)v : d;
        }
        return T <= hour;
    }
}