class Solution {
    
    int res = 0;
    
    public int removeStones(int[][] stones) {
        if(stones == null || stones.length == 0)
            return res;
        Set<int[]> visited = new HashSet<>();
        for(int i=0;i<stones.length;i++){
            dfs(stones, visited, stones[i]);
        }
        return res;
    }
    
    void dfs(int[][] stones, Set<int[]> set, int[] s) {
        if(set.contains(s))
            return;
        set.add(s);
        for(int i=0;i<stones.length;i++){
            int[] cur = stones[i];
            if(!set.contains(cur)) {
                if(cur[0] == s[0] || cur[1] == s[1]) {
                    dfs(stones, set, stones[i]);
                    res++;
                }
            }
        }
    }
}