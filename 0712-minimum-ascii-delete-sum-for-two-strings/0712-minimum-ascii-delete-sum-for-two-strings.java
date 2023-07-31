class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for(int i=0;i<s1.length();i++) {
            dp[i+1][0] = dp[i][0] + s1.charAt(i); 
        }
        for(int i=0;i<s2.length();i++) {
            dp[0][i+1] = dp[0][i] + s2.charAt(i); 
        }
        int res = 0;
        for(int i=1;i<dp.length;i++) {
            for(int j=1;j<dp[0].length;j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) 
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = Math.min(dp[i-1][j] + s1.charAt(i-1), dp[i][j-1] + s2.charAt(j-1));
            } 
        }
        return dp[dp.length-1][dp[0].length - 1];
    }
}