class Solution {
    class State{
        int i;
        int j;
        int mask;
        
        public State(int i, int j, int mask){
            this.i = i;
            this.j = j;
            this.mask = mask;
        }
    }
    public int shortestPathAllKeys(String[] grid1) {
        int si = -1, sj = -1, max = -1;
        char[][] grid = new char[grid1.length][grid1[0].length()];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                grid[i][j] = grid1[i].charAt(j);
            }
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                char c = (char)grid[i][j];
                if(c == '@'){
                    si = i;
                    sj = j;
                }
                if(c >= 'a' && c <= 'f'){
                    max = Math.max(c - 'a' + 1, max);
                }
            }
        }
        State start = new State(si, sj, 0);
        Queue<State> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        visited.add(start.i + "_" + start.j + "_" +start.mask);
        q.offer(start);
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int res = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                State cur = q.poll();
                if(cur.mask ==  (1 << max) - 1){
                    return res;
                }
                for(int[] dir : dirs){
                    int ni = cur.i + dir[0];
                    int nj = cur.j + dir[1];
                    int mask = cur.mask;
                    if(ni >=0 && ni < grid.length && nj >= 0 && nj < grid[0].length){
                        char c = (char)grid[ni][nj];
                        if(c == '#')
                            continue;
                        if(c >= 'a' && c <= 'f'){
                            mask |= 1 << (c - 'a');
                        }
                        if(c >= 'A' && c <= 'F' && ((mask >> (c - 'A')) & 1) == 0){
                            continue;
                        }
                        if(!visited.contains(ni + "_" + nj + "_" + mask)){
                            visited.add(ni + "_" + nj + "_" + mask);
                            q.offer(new State(ni, nj, mask));
                        }
                    }
                }
            }
            res++;
        }
        return -1;
    }
}