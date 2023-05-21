class Solution {
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public int shortestBridge(int[][] A) {
        if(A == null || A.length == 0){
            return 0;
        }
        boolean found = false;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[A.length][A[0].length];
        for(int i=0;i<A.length;i++){
            if(found) break;
            for(int j=0;j<A[0].length;j++){
                if(A[i][j] == 1){
                    dfs(A, visited, q, i, j);
                    found = true;
                    break;
                } 
            }
        }
        if(!found)
            return 0;
        int res = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] cur = q.poll();
                for(int[] dir : dirs){
                    int nx = cur[0] + dir[0];
                    int ny = cur[1] + dir[1];
                    if(nx >= 0 && nx < A.length && ny >= 0 && ny < A[0].length && !visited[nx][ny]){
                        if(A[nx][ny] == 1)
                            return res;
                        q.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
            res++;
        }
        return 0;
    }
    
    void dfs(int[][] A, boolean[][] visited, Queue<int[]> q, int i, int j){
        if(i < 0 || i >= A.length || j < 0 || j >= A[0].length || A[i][j] == 0 || visited[i][j])
            return;
        visited[i][j] = true;
        q.offer(new int[]{i, j});
        for(int[] dir : dirs){
            int ni = i + dir[0];
            int nj = j + dir[1];
            dfs(A, visited, q, ni, nj);
        }
    }
}