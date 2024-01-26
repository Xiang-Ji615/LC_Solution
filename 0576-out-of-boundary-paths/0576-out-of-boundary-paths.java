class Solution {
    public int findPaths(int m, int n, int N, int i, int j) {
        if (N <= 0) return 0;
        final int MOD = 1000000007;
        int[][][] dp = new int[N+1][m][n];
        int[][] dirs = {{0, 1}, {0,-1}, {1,0}, {-1,0}};
        int res = 0;
        dp[0][i][j] = 1;
        for(int step=1;step<=N;step++){
            for(int r=0;r<m;r++){
                for(int c=0;c<n;c++){
                  for(int[] dir : dirs){
                      int nr = r + dir[0];
                      int nc = c + dir[1];
                      if(nr < 0 || nr >= m || nc < 0 || nc >= n){
                          res = (res + dp[step-1][r][c])%MOD;
                      }else{
                          dp[step][nr][nc] = (dp[step][nr][nc] + dp[step-1][r][c])%MOD; 
                      }
                  }  
                }
            }
        }
        return res;
    }
}