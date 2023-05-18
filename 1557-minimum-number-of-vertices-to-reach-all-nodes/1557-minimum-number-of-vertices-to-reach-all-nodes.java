class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        for(List<Integer> e : edges){
            indegree.put(e.get(1), indegree.getOrDefault(e.get(1), 0) + 1);
        }
        for(int i=0;i<n;i++){
            if(!indegree.containsKey(i)){
                res.add(i);
            }
        }
        return res;
    }
}