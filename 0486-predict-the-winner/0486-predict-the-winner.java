class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        if(nums.length == 1)
            return true;
        for(int i=0;i<nums.length;i++){
            dp[i][i] = nums[i];
        }
        for(int l=1;l<nums.length;l++){
            for(int i=0;i+l<nums.length;i++){
                dp[i][i+l] = Math.max(nums[i] - dp[i+1][i+l], nums[i+l] - dp[i][i+l-1]);
            }
        }
        return dp[0][dp[0].length-1] >= 0; 
    }
}