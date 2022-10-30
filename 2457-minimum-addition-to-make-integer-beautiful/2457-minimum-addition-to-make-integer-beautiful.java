class Solution {
    public long makeIntegerBeautiful(long n, int target) {
        long n0=n, base = 1;
        while(sum(n) > target) {
            n = n/10+1;
            base *=10;
        }
        return n*base - n0;
    }
    
    int sum(long n) {
        int res = 0;
        while(n > 0) {
            res += n%10;
            n/=10;
        }
        return res;
    }
}