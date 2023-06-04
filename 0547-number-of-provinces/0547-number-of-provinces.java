class Solution {
    
    int res = 0;
    
    public int findCircleNum(int[][] isConnected) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i=0;i<isConnected.length;i++) {
            for(int j=0;j<isConnected[i].length;j++) {
                if(isConnected[i][j] == 1) {
                    map.putIfAbsent(i, new HashSet<>());
                    map.putIfAbsent(j, new HashSet<>());
                    map.get(i).add(j);
                    map.get(j).add(i);
                }
            }
        }
        boolean[] visited = new boolean[isConnected.length];
        for(int i=0;i<isConnected.length;i++) {
            if(!visited[i]) {
                dfs(map, visited, i);
                res++;
            }
        }
        return res;
    }
    
    void dfs(Map<Integer, Set<Integer>> map, boolean[] visited, int cur) {
        if(visited[cur])
            return;
        visited[cur] = true;
        for(int nei : map.getOrDefault(cur, new HashSet<>())) {
            dfs(map, visited, nei);
        }
        
    }
}