class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int maxD = 0;
        for(int d : difficulty){
            maxD = Math.max(d, maxD);
        }
        for(int w : worker)
            maxD = Math.max(w, maxD);
        int[] dp = new int[maxD + 1];
        for(int i=0;i<difficulty.length;i++){
            dp[difficulty[i]] = Math.max(profit[i], dp[difficulty[i]]);
        }
        for(int i=1;i<dp.length;i++)
            dp[i] = Math.max(dp[i], dp[i-1]);
        int res = 0;
        for(int w : worker)
            res += dp[w];
        return res;
    }
}