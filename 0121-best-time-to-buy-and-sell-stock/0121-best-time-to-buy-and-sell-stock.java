class Solution {
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        int res = 0, tmp = 0;
        for(int i=1;i<prices.length;i++) {
            dp[i] = prices[i] - prices[i-1];
        }
        for(int i=0;i<dp.length;i++) {
            tmp = Math.max(tmp + dp[i], dp[i]);
            res = Math.max(res, tmp);
        }
        return res;
    }
}