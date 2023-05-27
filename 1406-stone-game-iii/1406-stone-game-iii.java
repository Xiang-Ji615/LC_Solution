class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int l = stoneValue.length;
        int[] dp = new int[l+1];
        for(int i=l-1;i>=0;i--){
            dp[i] = Integer.MIN_VALUE;
            for(int j=0, take = 0; j <3 && j+i < l;j++){
                take += stoneValue[i+j];
                dp[i] = Math.max(dp[i], take - dp[i+j+1]);
            }
        }
        if(dp[0] > 0) return "Alice";
        if(dp[0] < 0) return "Bob";
        return "Tie";
    }
}