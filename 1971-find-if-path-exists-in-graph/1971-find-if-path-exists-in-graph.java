class Solution {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for(int[] e : edges){
            graph.putIfAbsent(e[0], new HashSet<>());
            graph.putIfAbsent(e[1], new HashSet<>());
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        visited.add(start);
        q.offer(start);
        while(!q.isEmpty()){
            int cur = q.poll();
            if(cur == end)
                return true;
            for(int nei : graph.get(cur)){
                if(!visited.contains(nei)){
                    visited.add(nei);
                    q.offer(nei);
                }
            }
        }
        return false;
    }
    
    boolean dfs(Map<Integer, Set<Integer>> g, int s, int e, Set<Integer> visited){
        if(visited.contains(s))
            return false;
        if(s == e)
            return true;
        visited.add(s);
        for(int nei : g.get(s)){
            if(dfs(g, nei, e, visited))
                return true;
        }
        visited.remove(s);
        return false;
    }
}