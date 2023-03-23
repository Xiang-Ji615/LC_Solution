class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1)
            return -1;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int[] c : connections){
            map.putIfAbsent(c[0], new HashSet<>());
            map.putIfAbsent(c[1], new HashSet<>());
            map.get(c[0]).add(c[1]);
            map.get(c[1]).add(c[0]);
        }
        boolean[] visited = new boolean[n];
        int res = 0;
        for(int i=0;i<n;i++){
            res += dfs(map, i, visited);
        }
        return res -1;
    }
    
    int dfs(Map<Integer, Set<Integer>> map, int cur, boolean[] visited){
        if(visited[cur])
            return 0;
        visited[cur] = true;
        if(map.containsKey(cur)){
            for(int nei : map.get(cur)){
                dfs(map, nei, visited);
            }
        }
        return 1;
    }
}