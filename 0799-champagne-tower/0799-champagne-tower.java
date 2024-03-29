class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[101][101];
        dp[0][0] = poured;
        for(int i=0;i<query_row+1;i++){
            for(int j=0;j<=i;j++){
                if(dp[i][j] >= 1){
                    dp[i+1][j] += (dp[i][j] - 1)/2.0;
                    dp[i+1][j+1] += (dp[i][j] - 1)/2.0;
                    dp[i][j] = 1;
                }
            }
        }
        return dp[query_row][query_glass];
    }
}