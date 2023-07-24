class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if(n < 0){
            N = -N;
            x = 1/x;
        }
        double curP = x;
        double res = 1.0;
        for(long i=N;i>0;i/=2){
            if(i%2 == 1)
                res *= curP;
            curP *= curP;
        }
        return res;
    }
}