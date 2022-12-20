class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if(rooms == null || rooms.size() == 0)
            return true;
        Set<Integer> visited = new HashSet<>();
        dfs(rooms, visited, 0);
        return visited.size() == rooms.size();
    }
    
    void dfs(List<List<Integer>> rooms, Set<Integer> visited, int cur){
        if(visited.contains(cur))
            return;
        visited.add(cur);
        for(int nei : rooms.get(cur)){
            dfs(rooms, visited, nei);
        }
    }
    
}