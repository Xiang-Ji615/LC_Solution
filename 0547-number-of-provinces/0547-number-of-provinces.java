class Solution {
    
   public int findCircleNum(int[][] M) {
        UF uf = new UF(M.length);
        for(int i=0;i<M.length;i++){
            for(int j=i+1;j<M[0].length;j++){
                if(M[i][j] == 1)
                    uf.union(i, j);
            }
        }
        return uf.cnt;
    }
    
    class UF{
        int[] p, w;
        int cnt;
    
        public UF(int n){
            p = new int[n];
            w = new int[n];
            Arrays.fill(w, 1);
            for(int i=0;i<n;i++){
                p[i] = i;
            }
            cnt = n;
        }
        
        public int find(int n){
            if(p[n] == n)
                return n;
            return p[n] = find(p[n]);
        }
        
        public void union(int a, int b){
            int pa = find(a);
            int pb = find(b);
            if(pa == pb)
                return;
            if(w[pa] > w[pb]){
                p[pb] = pa;
                w[pa] += w[pb];
            }else{
                p[pa] = pb;
                w[pb] += w[pa];
            }
            cnt--;
        }
    }
}