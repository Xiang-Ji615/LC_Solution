class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        if(graph == null || graph.length == 0)
            return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        // 0  UNKNOWN, 1, SAFE, 2, NOT SAFE
        int[] status = new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(dfs(graph, i, status)){
                res.add(i);
            }
        }
        return res;
    }
    
    boolean dfs(int[][] graph, int i, int[] status){
        if(status[i] != 0)
            return status[i] == 1;
        status[i] = -1;
        for(int nei : graph[i]){
            if(!dfs(graph, nei, status))
                return false;
        }
        status[i] = 1;
        return true;
    }
}