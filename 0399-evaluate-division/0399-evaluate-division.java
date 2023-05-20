class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        for(int i=0;i<equations.size();i++){
            List<String> e = equations.get(i);
            String s1 = e.get(0);
            String s2 = e.get(1);
            Double val = values[i];
            map.putIfAbsent(s1, new HashMap<>());
            map.putIfAbsent(s2, new HashMap<>());
            map.get(s1).put(s2, val);
            map.get(s2).put(s1, 1/val);
        }
        
        double[] res = new double[queries.size()];
        for(int i=0;i<queries.size();i++){
            Set<String> visited = new HashSet<>();
            List<String> q = queries.get(i);
            res[i] = dfs(map, q.get(0), q.get(1), visited);
        }
        return res;
    }
    
    double dfs(Map<String, Map<String, Double>> map, String start, String end, Set<String> visited){
        if(!map.containsKey(start)){
            return -1.0;
        }
        if(map.get(start).containsKey(end)){
            return map.get(start).get(end);
        }
        visited.add(start);
        for(Map.Entry<String, Double> nei : map.get(start).entrySet()){
            if(!visited.contains(nei.getKey())){
                double next = dfs(map, nei.getKey(), end, visited);
                if(next != -1.0)
                    return nei.getValue() * next;
            }
        }
        visited.remove(start);
        return -1.0;
    }
}