class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = 1, r = 0;
        for(int w : weights) {
            r += w;
            l = Math.max(l, w);
        }
        while(l < r) {
            int m = l + (r - l)/2;
            if(isValid(weights, days, m)) {
                r = m;
            }else{
                l = m + 1;
            }
        }
        return l;
    }
    
    boolean isValid(int[] weights, int d, int m) {
        int res = 0, cur = 0;
        for(int w : weights) {
            cur += w;
            if(cur > m) {
                res++;
                cur = w;
            }
            if(res > d) {
                return false;
            }
        }
        res++;
        return res <= d;
    }
}