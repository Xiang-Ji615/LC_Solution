class Solution {
    
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0},  {-1, 0}};
    int res = 0;
    
    public int numEnclaves(int[][] grid) {
        for(int i=0;i<grid.length;i++) {
            dfs(grid, i, 0);
            dfs(grid, i, grid[0].length - 1);
        }
        
        for(int i=0;i<grid[0].length;i++) {
            dfs(grid, 0, i);
            dfs(grid, grid.length - 1, i);
        }
        
        res = 0;
        for(int i=1;i<grid.length-1;i++) {
            for(int j=1;j<grid[0].length - 1;j++) {
                if(grid[i][j] == 1) {
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }
    
    void dfs(int[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0)
            return;
        grid[i][j] = 0;
        res++;
        for(int[] d : dirs) {
            dfs(grid, i + d[0], j + d[1]);
        }
    }
}