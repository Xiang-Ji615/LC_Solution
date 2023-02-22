class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int l = 1, r = 0;
        for(int w : weights){
            r += w;
            l = Math.max(l, w);
        }
        while(l < r){
            int m = l + (r - l)/2;
            if(isValid(weights, m, D)){
                r = m;
            }else{
                l = m+1;
            }
        }
        return l;
    }
    
    boolean isValid(int[] weights, int m, int d){
        int tmp = 0, res = 0;
        for(int w : weights){
            tmp += w;
            if(tmp > m){
                res++;
                tmp = w;
            }
            if(res > d)
                return false;
        }
        res++;
        return res <= d;
    }
}