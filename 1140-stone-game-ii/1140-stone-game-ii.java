class Solution {
    int[] preSum;
    int[][] dp;
    
    public int stoneGameII(int[] piles) {
        if(piles == null || piles.length == 0)
            return 0;
        int l = piles.length;
        preSum = new int[piles.length];
        preSum[l-1] = piles[l-1];
        for(int i = l -2; i>=0;i--) {
            preSum[i] = preSum[i+1] + piles[i]; //the sum from piles[i] to the end
        }
        System.out.println(Arrays.toString(preSum));
        dp = new int[l][l];
        return dfs(piles, 0, 1);
    }
    
    int dfs(int[] piles, int i, int m){
        if(i == piles.length)
            return 0;
        if(i + 2*m > piles.length){
            return preSum[i];
        }
        if(dp[i][m] != 0)
            return dp[i][m];
        int min = Integer.MAX_VALUE; //min value next player can get
        for(int j=1;j<=2*m;j++){
            min = Math.min(min, dfs(piles, i+j, Math.max(m, j)));
        }
        dp[i][m] = preSum[i] - min;
        return dp[i][m];
    }
}