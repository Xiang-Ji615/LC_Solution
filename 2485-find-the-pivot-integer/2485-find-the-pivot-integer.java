class Solution {
    public int pivotInteger(int n) {
        int l = 0, r = n;
        while(l <= r) {
            int m = l + (r - l)/2;
            int v = isValid(n, m);
            // System.out.println(m + ", " + v);
            if(v == 0) {
                return m;
            }else if(v > 0) {
                r = m - 1;
            }else{
                l = m + 1;
            }
        }
        return -1;
    }
    
    int isValid(int n, int m) {
        int sum = 0;
        for(int i=1;i<=n;i++){
            if(i <= m)
                sum += i;
            if(i >= m)
                sum -= i;
        }
        return sum;
    }
}