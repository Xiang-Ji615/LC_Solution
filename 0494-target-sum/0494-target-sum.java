class Solution {
    
    public int findTargetSumWays(int[] nums, int S) {
        if(nums == null || nums.length == 0)
            return 0;
        int sum = 0;
        for(int n : nums){
            sum += n;
        }
        if(Math.abs(sum) < Math.abs(S))
            return 0;
        int[][] dp = new int[nums.length+1][sum * 2 + 1];
        dp[0][sum] = 1;
        for(int i=1;i<dp.length;i++){
            int n = nums[i-1];
            for(int j=0;j<dp[0].length;j++){
                if(j >= n){
                    dp[i][j] += dp[i-1][j-n];
                }
                if(j < dp[0].length - n){
                    dp[i][j] += dp[i-1][j+n];
                }
            }
        }
        return dp[dp.length-1][sum + S];
    }
}