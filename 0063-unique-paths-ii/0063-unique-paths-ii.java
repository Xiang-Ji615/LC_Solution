class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        int[][] dp = new int[grid.length + 1][grid[0].length + 1];
        for(int i=1;i<=grid.length;i++){
            for(int j=1;j<=grid[0].length;j++){
                if(grid[i-1][j-1] == 1)
                    continue;
                else if(i == 1 && j == 1)
                    dp[i][j] = 1;
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[grid.length][grid[0].length];
    }
}