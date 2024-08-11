class Solution {
    
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public int minDays(int[][] grid) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    set.add(i * grid[0].length + j);
                }
            }
        }
        if(set.size() == 0)
            return 0;
        if(set.size() == 1)
            return 1;
        if(bfs(grid, set))
            return 0;
        Set<Integer> tmp = new HashSet<>(set);
        for(int n : set){
            tmp.remove(n);
            if(bfs(grid, tmp))
                return 1;
            tmp.add(n);
        }
        return 2;
    }
    
    boolean bfs(int[][] grid, Set<Integer> set){
        Queue<Integer> q = new LinkedList<>();
        int start = set.iterator().next();
        q.offer(start);
        Set<Integer> visited = new HashSet<>();
        visited.add(start);
        while(!q.isEmpty()){
            int cur = q.poll();
            visited.add(cur);
            int x = cur/grid[0].length;
            int y = cur%grid[0].length;
            for(int[] d : dirs){
                int nx = x + d[0], ny = y + d[1];
                if(nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length){
                    int k = nx * grid[0].length + ny;
                    if(!visited.contains(k) && set.contains(k)){
                        visited.add(k);
                        q.offer(k);
                    }
                }
            }
        }
        return visited.size() < set.size();
    }
}