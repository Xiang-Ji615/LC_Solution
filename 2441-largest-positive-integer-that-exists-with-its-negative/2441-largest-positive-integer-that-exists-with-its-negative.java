class Solution {
    public int findMaxK(int[] nums) {
        boolean[] cnt = new boolean[2001];
        int res = -1;
        for(int n : nums) {
            cnt[n+1000] = true;
            if(cnt[n + 1000] && cnt[1000 - n]) {
                res = Math.max(res, Math.abs(n));
            }
        }
        return res;
    }
}