class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int[] p : adjacentPairs){
            set.add(p[0]);
            set.add(p[1]);
            map.putIfAbsent(p[0], new HashSet<>());
            map.putIfAbsent(p[1], new HashSet<>());
            map.get(p[0]).add(p[1]);
            map.get(p[1]).add(p[0]);
        }
        List<Integer> lst = new ArrayList<>();
        int s = 0;
        for(Map.Entry<Integer, Set<Integer>> e : map.entrySet()){
            if(e.getValue().size() == 1){
                s = e.getKey();
                break;
            }
        }
        Set<Integer> visited = new HashSet<>();
        dfs(map, visited, s, lst);
        int[] res = new int[lst.size()];
        for(int i=0;i<lst.size();i++)
            res[i] = lst.get(i);
        return res;
    }
    
    boolean dfs(Map<Integer, Set<Integer>> map, Set<Integer> visited, int cur, List<Integer> lst){
        if(lst.size() == map.keySet().size())
            return true;
        if(!visited.add(cur))
            return false;
        lst.add(cur);
        for(int nei : map.getOrDefault(cur, new HashSet<>())){
            if(dfs(map, visited, nei, lst))
                return true;
        }
        lst.remove(lst.size() - 1);
        return false;
    }
}