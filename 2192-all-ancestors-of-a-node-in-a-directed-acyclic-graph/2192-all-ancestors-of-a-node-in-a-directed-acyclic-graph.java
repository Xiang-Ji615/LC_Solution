class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int[] e : edges){
            map.putIfAbsent(e[1], new HashSet<>());
            map.get(e[1]).add(e[0]);
        }
        Map<Integer, Set<Integer>> dp = new HashMap<>();
        for(int i=0;i<n;i++){
            res.add(new ArrayList<>(dfs(map, dp, i)));
        }
        return res;
    }
    
    Set<Integer> dfs(Map<Integer, Set<Integer>> map, Map<Integer, Set<Integer>> dp, int cur){
        if(dp.containsKey(cur))
            return dp.get(cur);
        Set<Integer> set = new TreeSet<>();
        for(int nei: map.getOrDefault(cur, new HashSet<>())){
            set.add(nei);
            set.addAll(dfs(map, dp, nei));
        }
        dp.put(cur, set);
        return set;
    }
    
}