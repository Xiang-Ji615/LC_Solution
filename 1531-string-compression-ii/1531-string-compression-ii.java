class Solution {
    
    Integer[][][] memo;
    
    public int getLengthOfOptimalCompression(String s, int k) {
        List<int[]> lst = new ArrayList<>();
        char lc = ' ';
        int cnt = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(lc != c){
                if(cnt != 0) lst.add(new int[]{lc - 'a', cnt});
                cnt = 1;
                lc = c;
            }else{
                cnt++;
            }
        }
        lst.add(new int[]{lc - 'a', cnt});
        memo = new Integer[lst.size() + 1][k+1][s.length() + 1];
        return dfs(lst, 0, 0, k);
    }
    
    int dfs(List<int[]> lst, int a, int i, int k){
        if(i == lst.size())
            return 0;
        if(memo[i][k][a] != null)
            return memo[i][k][a];
        int[] cur = lst.get(i);
        int c = cur[1] + a;
        
        int best = l(c) + dfs(lst, 0, i+1, k);
        
        for(int q : new int[]{0, 1, 9}){
            int toRemove = c - q;
            if(toRemove <= k && q < c){
                best = Math.min(best, dfs(lst, 0, i+1, k - toRemove) + l(q));
            }
        }
        
        int res = k;
        
        for(int j=i+1;j<lst.size() && res >= 0;j++){
            int[] next = lst.get(j);
            if(next[0] == cur[0]){
                best = Math.min(best, dfs(lst, c, j, res));
                break;
            }
            res -= next[1];
        }
        
        memo[i][k][a] = best;
        
        return best;
    }
    
    int l(int n){
        if(n <= 1)
            return n;
        if(n < 10)
            return 2;
        if(n < 100)
            return 3;
        return 4;
    }
}