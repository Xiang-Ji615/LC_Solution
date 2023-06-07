class Solution {
    public int minFlips(int a, int b, int c) {
        int res = 0;
        while(a!=0 || b!=0 || c!=0){
            int ar= a%2, br = b%2, cr = c%2;
            if(cr == 0)
                res += ar + br;
            else{
                if(ar + br == 0)
                    res += 1;
            }
            a/=2;
            b/=2;
            c/=2;
        }
        return res;
    }
}