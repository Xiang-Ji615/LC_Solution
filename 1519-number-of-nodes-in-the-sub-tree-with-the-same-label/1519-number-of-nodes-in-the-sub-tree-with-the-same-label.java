class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int[] e : edges){
            map.putIfAbsent(e[0], new HashSet<>());
            map.putIfAbsent(e[1], new HashSet<>());
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }
        int[] res = new int[n];
        Set<Integer> visited = new HashSet<>();
        dfs(map, visited, labels, res, 0);
        return res;
    }
    
    int[] dfs(Map<Integer, Set<Integer>> map, Set<Integer> visited, String labels, int[] res, int cur){
        int[] cnt = new int[26];
        if(visited.add(cur)){
            char c = labels.charAt(cur);
            for(int nei : map.getOrDefault(cur, new HashSet<>())){
                int[] next = dfs(map, visited, labels, res, nei);
                for(int i=0;i<26;i++){
                    cnt[i] += next[i];
                }
            }
            cnt[c - 'a']++;
            res[cur] = cnt[c - 'a'];
        }
        return cnt;
    }
}