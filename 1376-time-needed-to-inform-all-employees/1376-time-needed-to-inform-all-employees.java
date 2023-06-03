class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int total = 0;
        for(int i=0;i<manager.length;i++){
            int j = manager[i];
            map.putIfAbsent(j, new ArrayList<>());
            map.get(j).add(i);
        }
        return dfs(map, informTime, headID);
    }
    
    int dfs(Map<Integer, List<Integer>> map, int[] informTime, int cur){
        int res = 0;
        if(!map.containsKey(cur))
            return res;
        for(int nei : map.get(cur)){
            res = Math.max(res, dfs(map, informTime, nei));
        }
        return res + informTime[cur];
    }
}