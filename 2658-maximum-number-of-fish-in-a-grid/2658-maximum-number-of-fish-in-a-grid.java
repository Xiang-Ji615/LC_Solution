class Solution {
    
    int[][] dirs  = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int res = 0;
    
    public int findMaxFish(int[][] grid) {
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] > 0) {
                    res = Math.max(res, dfs(grid, i, j));
                }
            }
        }
        return res;
    }
    
    int dfs(int[][] grid, int i, int j) {
        int res = grid[i][j];
        grid[i][j] = 0;
        for(int[] d : dirs) {
            int ni = i + d[0], nj = j + d[1];
            if(ni >= 0 && ni < grid.length && nj >=0 && nj < grid[0].length && grid[ni][nj] > 0) {
                res += dfs(grid, ni, nj);
            }
        }
        return res;
    }
}