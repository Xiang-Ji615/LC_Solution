class Solution {
    public int maxProfit(int[] prices, int fee) {
        // int l = prices.length;
        // int[] buy = new int[l];
        // int[] sell = new int[l];
        // buy[0] = -prices[0];
        // for(int i=1;i<l;i++){
        //     buy[i] = Math.max(buy[i-1], sell[i-1] - prices[i]);
        //     sell[i] = Math.max(sell[i-1], buy[i-1] + prices[i] - fee);
        // }
        // return Math.max(buy[l-1], sell[l-1]);
        
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        for(int i=1;i<prices.length;i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i] - fee);
        }
        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);
    }
}