class Solution {
    
    class State {
        int node;
        double val;
        
        public State(int node, double val) {
            this.node = node;
            this.val = val;
        }
    }
    
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, Map<Integer, Double>> map = new HashMap<>();
        for(int i=0;i<edges.length;i++) {
            int[] e = edges[i];
            map.putIfAbsent(e[0], new HashMap<>());
            map.putIfAbsent(e[1], new HashMap<>());
            map.get(e[0]).put(e[1], succProb[i]);
            map.get(e[1]).put(e[0], succProb[i]);
        }
        
        Queue<State> q = new LinkedList<>();
        q.offer(new State(start, 1.0));
        double[] vals = new double[n];
        while(!q.isEmpty()) {
            State cur = q.poll();
            int parent = cur.node;
            double v = cur.val;
            for(Map.Entry<Integer, Double> nei : map.getOrDefault(parent, new HashMap<>()).entrySet()) {
                if(vals[nei.getKey()] >= v * nei.getValue())
                    continue;
                q.offer(new State(nei.getKey(), v * nei.getValue()));
                vals[nei.getKey()] = v * nei.getValue();
            }
        }
        return vals[end];
    }
}