class Solution {
    public int strangePrinter(String s) {
        int l = s.length();
        int[][] memo = new int[l][l];
        return helper(s, 0, l-1, memo);
    }
    
    int helper(String s, int l, int r, int[][] memo){
        if(l > r)
            return 0;
        if(memo[l][r] > 0){
            return memo[l][r];
        }
        int res = helper(s, l, r-1, memo) + 1;
        for(int i=l;i<r;i++){
            if(s.charAt(i) == s.charAt(r)){
                res = Math.min(res, helper(s, l, i, memo) + helper(s, i+1, r-1, memo));
            }
        }
        memo[l][r] = res;
        return res;
    }
}