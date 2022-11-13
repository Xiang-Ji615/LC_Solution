class Solution {
    public int subarrayLCM(int[] nums, int k) {
        int res = 0, l = nums.length;
        for(int i=0;i<l;i++){
            int n = 1;
            for(int j=i;j<l;j++){
                n=cnt(n, nums[j]);
                res += (n == k) ? 1 : 0;
            }
        }
        return res;
    }
    
    int gcd(int a, int b){
        if(b == 0)
            return a;
        return gcd(b, a%b);
    }
    
    int cnt(int a, int b){
        return a*b/gcd(a, b);
    }
}