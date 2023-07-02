class Solution {
    
    int res = 0;
    
    public int maximumRequests(int n, int[][] requests) {
        dfs(requests, new int[n], 0, 0);
        return res;
    }
    
    void dfs(int[][] requests, int[] cnt, int cur, int tmp) {
        if(cur == requests.length) {
            for(int c : cnt) {
                if(c != 0)
                    return;
            }
            res = Math.max(tmp, res);
            return;
        }
        cnt[requests[cur][0]]--;
        cnt[requests[cur][1]]++;
        dfs(requests, cnt, cur+1, tmp+1);
        cnt[requests[cur][0]]++;
        cnt[requests[cur][1]]--;
        
        dfs(requests, cnt, cur+1, tmp);
    }
}