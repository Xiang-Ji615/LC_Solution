class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<manager.length;i++){
            int j = manager[i];
            map.putIfAbsent(j, new ArrayList<>());
            map.get(j).add(i);
        }
        return dfs(map, informTime, headID);
    }
    
    int dfs(Map<Integer, List<Integer>> map, int[] arr, int cur) {
        if(!map.containsKey(cur)) {
            return 0;
        }
        int res = 0;
        for(int nei : map.getOrDefault(cur, new ArrayList<>())) {
            res = Math.max(res, dfs(map, arr, nei));
        }
        return res + arr[cur];
    }
}