class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int[][] dirs = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> q = new LinkedList<>();
        q.offer(entrance);
        maze[entrance[0]][entrance[1]] = '+';
        int res = 0;
        int cnt = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] cur = q.poll();
                if(cnt++ > 0 && (cur[0] == 0 || cur[1] == 0 || cur[0] == maze.length - 1 || cur[1] == maze[0].length - 1))
                    return res;
                for(int[] d : dirs){
                    int nx = cur[0] + d[0], ny = cur[1] + d[1];
                    if(nx >= 0 && nx < maze.length && ny >= 0 && ny < maze[0].length && maze[nx][ny] == '.') {
                        maze[nx][ny] = '+';
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
            res++;
        }
        return -1;
    }
}