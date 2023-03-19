class Solution {
    
    int[][] dirs = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
    
    public boolean checkValidGrid(int[][] grid) {
        return dfs(grid, 0, 0, 0, 1);
    }
    
    boolean dfs(int[][] grid, int x, int y, int cur, int visited) {
        if(visited == grid[0].length * grid[1].length)
            return true; 
        boolean res = false;
        for(int[] next : dirs) {
            int nx = x + next[0];
            int ny = y + next[1];
            if(nx < 0 || nx >= grid.length || ny < 0 || ny >= grid[0].length || grid[nx][ny] != cur + 1)
                continue;
            res |= dfs(grid, nx, ny, cur+1, visited + 1);
        }
        return res;
    }
}