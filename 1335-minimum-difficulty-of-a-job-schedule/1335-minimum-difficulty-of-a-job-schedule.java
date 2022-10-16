class Solution {
    public int minDifficulty(int[] job, int d) {
        if(job == null || job.length == 0)
            return 0;
        if(d > job.length)
            return -1;
        int[][] dp = new int[d+1][job.length + 1];
        for(int i=1;i<job.length;i++){
            dp[0][i] = Math.max(dp[0][i-1], job[i-1]);
        }
        for(int i=1;i<=d;i++){
            for(int j=1;j<=job.length;j++){
                int max = job[j-1];
                dp[i][j] = Integer.MAX_VALUE;
                for(int k=j;k>=i;k--){
                    max = Math.max(max, job[k-1]);
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][k - 1] + max);
                }
            }
        }
        return dp[d][job.length];
    }
}