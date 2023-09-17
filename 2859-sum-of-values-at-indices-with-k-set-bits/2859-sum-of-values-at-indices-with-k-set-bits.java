class Solution {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int[] dp = new int[1001];
        for(int i=1;i<dp.length;i++) {
            dp[i] = dp[i>>1] + (i&1);
        }
        int res = 0;
        for(int i=0;i<nums.size();i++) {
            if(dp[i] == k)
                res += nums.get(i);
        }
        return res;
    }
}