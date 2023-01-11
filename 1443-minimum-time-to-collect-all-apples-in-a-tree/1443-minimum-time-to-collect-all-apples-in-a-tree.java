class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int[] e : edges){
            map.putIfAbsent(e[0], new HashSet<>());
            map.putIfAbsent(e[1], new HashSet<>());
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }
        Set<Integer> visited = new HashSet<>();
        return dfs(0, map, visited, hasApple);
    }
    
    int dfs(int cur, Map<Integer, Set<Integer>> map, Set<Integer> visited, List<Boolean> hasApple){
        visited.add(cur);
        int res = 0;
        for(int nei : map.getOrDefault(cur, new HashSet<>())){
            if(!visited.contains(nei)){
                res += dfs(nei, map, visited, hasApple);
            }
        }
        if((res > 0 || hasApple.get(cur)) && cur != 0)
            res +=2;
        return res;
    }
}