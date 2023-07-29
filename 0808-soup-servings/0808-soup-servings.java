class Solution {
    int[][] nextRound = {{100, 0}, {75, 25}, {50,50}, {25, 75}};
    public double soupServings(int N) {
        if(N > 5000)
            return 1.0;
        Double[][] memo = new Double[N+1][N+1]; 
        return dfs(N, N, memo);
    }
    
    double dfs(int A, int B, Double[][] memo){
        if(A <= 0 && B <= 0)
            return 0.5;
        if(A <= 0)
            return 1.0;
        if(B <= 0)
            return 0.0;
        if(memo[A][B] != null)
            return memo[A][B];
        memo[A][B] = 0.0;
        for(int i=0;i<4;i++){
            memo[A][B] += dfs(A-nextRound[i][0], B - nextRound[i][1], memo);
        }
        memo[A][B]/=4;
        return memo[A][B];
    }
}