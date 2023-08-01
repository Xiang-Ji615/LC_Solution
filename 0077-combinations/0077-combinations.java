class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(n, k, res, 1, new ArrayList<>());
        return res;
    }
    
    void dfs(int n, int k, List<List<Integer>> res, int cur, List<Integer> tmp){
        if(tmp.size() == k){
            res.add(new ArrayList<>(tmp));
            return;
        }
        if(cur > n)
            return;
        for(int i=cur;i<=n;i++){
            tmp.add(i);
            dfs(n, k, res, i+1, tmp);
            tmp.remove(tmp.size() - 1);
        }
        
    }
}