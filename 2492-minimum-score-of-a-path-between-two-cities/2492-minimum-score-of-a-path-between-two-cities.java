class Solution {
    public int minScore(int n, int[][] roads) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for(int[] r : roads) {
            map.putIfAbsent(r[0], new HashMap<>());
            map.putIfAbsent(r[1], new HashMap<>());
            map.get(r[0]).put(r[1], r[2]);
            map.get(r[1]).put(r[0], r[2]);
        }
        Set<Integer> visited = new HashSet<>();
        visited.add(1);
        return dfs(map, visited, 1, n, Integer.MAX_VALUE);
    }
    
    int dfs(Map<Integer, Map<Integer, Integer>> map, Set<Integer> visited, int cur, int target, int res) {
        for(Map.Entry<Integer, Integer> nei : map.getOrDefault(cur, new HashMap<>()).entrySet()) {
            res = Math.min(res, nei.getValue());
            if(visited.add(nei.getKey())) {
                res = Math.min(res, dfs(map, visited, nei.getKey(), target, res));
            }
        }
        return res;
    }
}