class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        boolean[][] map = new boolean[n][n];
        int[] cnt = new int[n];
        for(int[] r : roads){
            cnt[r[0]]++;
            cnt[r[1]]++;
            map[r[0]][r[1]] = true;
            map[r[1]][r[0]] = true;
        }
        int res = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                res = Math.max(res, cnt[i] + cnt[j] - (map[i][j] ? 1 : 0));
            }
        }
        return res;
    }
}