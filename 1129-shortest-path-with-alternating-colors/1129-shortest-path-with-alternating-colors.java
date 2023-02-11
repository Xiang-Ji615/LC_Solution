class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Map<Integer, List<Integer>> rGraph = new HashMap<>();
        Map<Integer, List<Integer>> bGraph = new HashMap<>();
        for(int[] edge : red_edges){
            List<Integer> lst = rGraph.getOrDefault(edge[0], new ArrayList<>());
            lst.add(edge[1]);
            rGraph.put(edge[0], lst);
        }
        for(int[] edge : blue_edges){
            List<Integer> lst = bGraph.getOrDefault(edge[0], new ArrayList<>());
            lst.add(edge[1]);
            bGraph.put(edge[0], lst);
        }
        Set<Integer> rSeen = new HashSet<>();
        Set<Integer> bSeen = new HashSet<>();
        bSeen.add(0);
        rSeen.add(0);
        Queue<int[]> q = new LinkedList<>(); // node : color
        q.offer(new int[]{0, 0});
        q.offer(new int[]{0, 1});
        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] nC = q.poll();
                int node = nC[0];
                int color = nC[1];
                res[node] = res[node] >= 0 ? Math.min(res[node], steps) : steps;
                Map<Integer, List<Integer>> nextGraph = color == 1 ? rGraph : bGraph;
                Set<Integer> nextSeen = color == 1 ? rSeen : bSeen;
                for(int next : nextGraph.getOrDefault(node, new ArrayList<>())){
                    if(nextSeen.contains(next))
                        continue;
                    nextSeen.add(next);
                    q.offer(new int[]{next, 1-color});
                }
            }
            steps++;
        }
        return res;
    }
}