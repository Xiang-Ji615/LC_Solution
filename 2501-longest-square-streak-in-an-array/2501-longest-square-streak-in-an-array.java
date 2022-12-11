class Solution {
    public int longestSquareStreak(int[] nums) {
        int[] dp = new int[100001];
        Arrays.sort(nums);
        int res = 0;
        for(int n : nums) {
            int s = (int)Math.sqrt(n);
            if(s * s == n) {
                dp[n] = Math.max(1, dp[s] + 1);
            }else{
                dp[n] = 1;
            }
            res = Math.max(res, dp[n]);
        }
        return res < 2 ? -1 : res;
    }
}