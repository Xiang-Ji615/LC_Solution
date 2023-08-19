class Solution {
    
    class UF{
        int[] p;
        int cnt;
        
        public UF(int n){
            p = new int[n];
            cnt = n;
            for(int i=0;i<p.length;i++){
                p[i] = i;
            }
        }
        
        public int find(int n){
            if(p[n] != n){
                p[n] = find(p[n]);
            }
            return p[n];
        }
        
        public boolean union(int i, int j){
            int pi = find(i);
            int pj = find(j);
            if(pi != pj){
                cnt--;
                p[pi] = pj;
                return true;
            }
            return false;
        }
    }
    
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> c = new ArrayList<>();
        List<Integer> p = new ArrayList<>();
        Map<int[], Integer> map = new HashMap<>();
        for(int i=0;i<edges.length;i++){
            map.put(edges[i], i);
        }
        Arrays.sort(edges, (a, b)->a[2] - b[2]);
        int minCost = buildMST(n, edges, null, null);
        for(int i=0;i<edges.length;i++){
            int[] cur = edges[i];
            int idx = map.get(cur);
            int costWithout = buildMST(n, edges, null, cur);
            if(costWithout > minCost){
                c.add(idx);
            }else{
                int costWith = buildMST(n, edges, cur, null);
                if(costWith == minCost)
                    p.add(idx);
            }
        }
        res.add(c); res.add(p);
        return res;
    }
    
    int buildMST(int n, int[][] edges, int[] pick, int[] skip){
        UF uf = new UF(n);
        int cost = 0;
        if(pick != null){
            uf.union(pick[0], pick[1]);
            cost += pick[2];
        }
        for(int[] e : edges){
            if(e != skip && uf.union(e[0], e[1])){
                cost += e[2];
            }
        }
        return uf.cnt == 1 ? cost : Integer.MAX_VALUE;
    }
}