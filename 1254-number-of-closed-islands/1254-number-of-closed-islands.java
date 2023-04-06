class Solution {
    
    int res = 0;
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public int closedIsland(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 0){
                    if(dfs(grid, i, j))
                        res++;
                }
            }
        }
        return res;
    }
    
    boolean dfs(int[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
            return false;
        if(grid[i][j] == 1)
            return true;
        grid[i][j] = 1;
        boolean res = true;
        for(int[] dir : dirs){
            res = res & dfs(grid, i + dir[0], j + dir[1]);
        }
        return res;
    }
}