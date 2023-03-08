class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = Integer.MAX_VALUE;
        while(l < r) {
            int m = l + (r - l)/2;
            if(isValid(piles, h, m)){
                r = m;
            }else{
                l = m + 1;
            }
        }
        return l;
    }
    
    boolean isValid(int[] piles, int h, int m) {
        int cnt = 0;
        for(int p : piles) {
            cnt += p/m;
            if(p%m > 0) {
                cnt++;
            }
        }
        return cnt <= h;
    }
}