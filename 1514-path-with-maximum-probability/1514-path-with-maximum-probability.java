class Solution {
    
    class State{
        int node;
        double prob;
        
        public State(int node, double prob){
            this.node = node;
            this.prob = prob;
        }
    }
    
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, Map<Integer, Double>> map = new HashMap<>();
        for(int i=0;i<edges.length;i++){
            int[] e = edges[i];
            map.putIfAbsent(e[0], new HashMap<>());
            map.putIfAbsent(e[1], new HashMap<>());
            map.get(e[0]).put(e[1], succProb[i]);
            map.get(e[1]).put(e[0], succProb[i]);
        }
        double[] probs= new double[n];
        Queue<State> q = new LinkedList<>();
        q.offer(new State(start, 1.0));
        while(!q.isEmpty()){
            State cur = q.poll();
            int parent = cur.node;
            double prob = cur.prob;
            for(Map.Entry<Integer, Double> e : map.getOrDefault(parent, new HashMap<>()).entrySet()){
                if(probs[e.getKey()] >= prob * e.getValue())
                    continue;
                q.offer(new State(e.getKey(), prob*e.getValue()));
                probs[e.getKey()] = prob * e.getValue();
            }
        }
        return probs[end];
    }
    
    // void dfs(Map<Integer, Map<Integer, Double>> map, boolean[] visited, int cur, int end, double tmp){
    //     if(visited[cur])
    //         return;
    //     if(cur == end){
    //         res = Math.max(res, tmp);
    //         return;
    //     }
    //     visited[cur] = true;
    //     for(Map.Entry<Integer, Double> nei : map.getOrDefault(cur, new HashMap<>()).entrySet()){
    //         dfs(map, visited, nei.getKey(), end, tmp * nei.getValue());
    //     }
    //     visited[cur] = false;
    // }
}