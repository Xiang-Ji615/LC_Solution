class Solution {
    
    int[] res, count;
    List<Set<Integer>> lst;
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        res = new int[N];
        count = new int[N];
        Arrays.fill(count, 1);
        lst = new ArrayList<>();
        for(int i=0;i<N;i++)
            lst.add(new HashSet<>());
        for(int[] edge : edges){
            lst.get(edge[0]).add(edge[1]);
            lst.get(edge[1]).add(edge[0]);
        }
        // System.out.println(lst);
        dfs1(0, -1);
        dfs2(0, -1);
        return res;
    }
    
    void dfs1(int root, int pre){
        for(int i : lst.get(root)){
            if(i == pre)
                continue;
            dfs1(i, root);
            count[root] += count[i];
            res[root] += res[i] + count[i];
        }
    }
    
    void dfs2(int root, int pre){
        for(int i : lst.get(root)){
            if(i == pre)
                continue;
            res[i] = res[root] + count.length - 2*count[i];
            dfs2(i, root);
        }
    }
    
    
}