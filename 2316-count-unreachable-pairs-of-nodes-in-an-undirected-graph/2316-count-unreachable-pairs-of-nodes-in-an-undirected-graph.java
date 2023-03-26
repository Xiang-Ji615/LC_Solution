class Solution {
    public long countPairs(int n, int[][] edges) {
        long res = 0, sum = n;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int[] e : edges){
            map.putIfAbsent(e[0], new HashSet<>());
            map.putIfAbsent(e[1], new HashSet<>());
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                int connected = dfs(map, visited, i);
                sum = sum - connected;
                res += sum * connected;
            }
        }
        return res;
    }
    
    int dfs(Map<Integer, Set<Integer>> map, boolean[] visited, int cur) {
        if(visited[cur])
            return 0;
        visited[cur] = true;
        int res = 1;
        for(int nei : map.getOrDefault(cur, new HashSet<>())){
            if(!visited[nei]){
                res += dfs(map, visited, nei);
            }
        }
        return res;
    }
}