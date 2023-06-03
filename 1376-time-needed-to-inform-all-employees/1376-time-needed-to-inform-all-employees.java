class Solution {
    
    int res = 0;
    
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<manager.length;i++){
            int j = manager[i];
            map.putIfAbsent(j, new ArrayList<>());
            map.get(j).add(i);
        }
        dfs(map, informTime, headID, 0);
        return res;
    }
    
    void dfs(Map<Integer, List<Integer>> map, int[] arr, int cur, int n) {
        if(!map.containsKey(cur)) {
            res = Math.max(res, n);
            return;
        }
        for(int nei : map.getOrDefault(cur, new ArrayList<>())) {
            dfs(map, arr, nei, n + arr[cur]);
        }
    }
}