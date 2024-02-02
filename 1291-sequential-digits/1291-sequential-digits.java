class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        for(int i=1;i<=9;i++) {
            dfs(res, low, high, i);
        }
        Collections.sort(res);
        return res;
    }
    
    void dfs(List<Integer> res, int l, int h, int cur) {
        if(cur > h) 
            return;
        if(cur % 10 == 9){
            if(cur >= l)
                res.add(cur);
            return;
        }
        if(cur >= l && cur <= h)
            res.add(cur);
        dfs(res, l, h, cur * 10 + cur % 10 + 1);
    }
}