class Solution {
    
    long res = 0;
    int s = 0;
    
    public long minimumFuelCost(int[][] roads, int seats) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        s = seats;
        for(int[] r : roads) {
            map.putIfAbsent(r[0], new HashSet<>());
            map.putIfAbsent(r[1], new HashSet<>());
            map.get(r[0]).add(r[1]);
            map.get(r[1]).add(r[0]);
        }
        dfs(0, 0, map);
        return res;
    }
    
    int dfs(int cur, int prev, Map<Integer, Set<Integer>> map) {
        int people = 1;
        for(int nei : map.getOrDefault(cur, new HashSet<>())) {
            if(nei == prev) continue;
            people += dfs(nei, cur, map);
        }
        if(cur != 0) 
            res += (people + s - 1)/s;
        return people;
    }
}