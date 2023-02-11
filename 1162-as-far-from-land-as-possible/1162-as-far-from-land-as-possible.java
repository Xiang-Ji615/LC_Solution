class Solution {
    public int maxDistance(int[][] grid) {
        if(grid == null && grid.length == 0)
            return 0;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> q = new LinkedList<>();
        int res = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        while(!q.isEmpty()){
            int s = q.size();
            for(int k=0;k<s;k++){
                int[] p = q.poll();
      
                res = Math.max(res, grid[p[0]][p[1]] - 1);
                for(int[] dir : dirs){
                    int nx = p[0] + dir[0];
                    int ny = p[1] + dir[1];
                    if(nx < 0 || nx >= grid.length || ny < 0 || ny >= grid[0].length || grid[nx][ny] == 1 || visited[nx][ny])
                        continue;
                    else{
                        visited[nx][ny] = true;
                        grid[nx][ny] = grid[p[0]][p[1]] + 1;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        // for(int[] row : grid){
        //     System.out.println(Arrays.toString(row));
        // }
        return res == 0 ? -1 : res;
    }
}