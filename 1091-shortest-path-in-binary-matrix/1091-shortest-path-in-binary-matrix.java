class Solution {
    
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}};
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        if(grid[0][0] == 0) q.offer(new int[]{0, 0});
        int res = 1;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[0][0] = true;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                int[] cur = q.poll();
                if(cur[0] == grid.length - 1 && cur[1] == grid[0].length - 1){
                    return res;
                }
                for(int[] d : dirs) {
                    int ni = cur[0] + d[0];
                    int nj = cur[1] + d[1];
                    if(ni >= 0 && ni < grid.length && nj >= 0 && nj < grid[0].length && !visited[ni][nj] && grid[ni][nj] == 0) {
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