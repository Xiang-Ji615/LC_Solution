class Solution {
    public int pivotInteger(int n) {
        int sum = 0;
        for(int i=1;i<=n;i++) {
            sum += i;
        }
        int s = 0;
        for(int i=0;i<=n;i++) {
            s += i;
            if(s * 2 - i == sum)
                return i;
        }
        return -1;
    }
}