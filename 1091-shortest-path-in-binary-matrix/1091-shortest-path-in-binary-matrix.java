class Solution {
    
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        if(grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1)
            return -1;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        visited[0][0] = true;
        int res = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] cur = q.poll();
                if(cur[0] == grid.length - 1 && cur[1] == grid[0].length - 1){
                    return res;
                }
                for(int[] d : dirs){
                    int ni = cur[0] + d[0], nj = cur[1] + d[1];
                    if(ni >= 0 && ni < grid.length && nj >= 0 && nj < grid[0].length && !visited[ni][nj] && grid[ni][nj] == 0){
                        q.offer(new int[]{ni, nj});
                        visited[ni][nj] = true;
                    }
                }
            }
            res++;
        }
        return -1;
    }
}