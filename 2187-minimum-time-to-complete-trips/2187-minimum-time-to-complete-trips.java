class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long l = 0, r = 100000000000000L;
        while(l < r) {
            long m = l + (r - l)/2;
            if(isValid(m, totalTrips, time)) {
                r = m;
            }else{
                l = m + 1;
            }
        }
        return l;
    }
    
    boolean isValid(long m, int t, int[] nums) {
        long res = 0;
        for(int n : nums) {
            res += m/n;
        }
        return res >= t;
    }
}