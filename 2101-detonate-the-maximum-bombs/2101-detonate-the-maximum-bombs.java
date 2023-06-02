class Solution {
    
    int cnt = 0;
    
    public int maximumDetonation(int[][] bombs) {
        int l = bombs.length, res = 0;
        for(int i=0;i<l;i++){
            res = Math.max(res, dfs(i, new boolean[l], bombs));
        }
        return res;
    }
    
    int dfs(int cur, boolean[] visited, int[][] arr){
        int res = 1;
        visited[cur] = true;
        for(int i=0;i<arr.length;i++){
            if(!visited[i] && isRange(arr[cur], arr[i])){
                visited[i] = true;
                res += dfs(i, visited, arr);
            }
        }
        return res;
    }
    
    boolean isRange(int[] a, int[] b){
        long dx = a[0] - b[0], dy = a[1] - b[1], r = a[2];
        return dx * dx + dy * dy <= r * r;
    }
}