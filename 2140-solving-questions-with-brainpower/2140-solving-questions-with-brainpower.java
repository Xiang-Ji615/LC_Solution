class Solution {
    public long mostPoints(int[][] questions) {
        if(questions.length == 1){
            return questions[0][0];
        }
        long[] dp = new long[questions.length];
        dp[questions.length - 1] = questions[questions.length - 1][0];
        for(int i=questions.length - 2;i>=0;i--){
            long tmp = i + questions[i][1]  + 1 < questions.length ? dp[i + questions[i][1] + 1] : 0;
            dp[i] = Math.max(dp[i+1], questions[i][0] + tmp);
        }
        return dp[0];
    }
}