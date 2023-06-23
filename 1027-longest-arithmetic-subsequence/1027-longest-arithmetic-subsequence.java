class Solution {
    public int longestArithSeqLength(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        Map<Integer, Integer>[] dp = new Map[nums.length];
        int res = 1;
        for(int i=0;i<nums.length;i++) {
            dp[i] = new HashMap<>();
            for(int j=0;j<i;j++) {
                int diff = nums[i] - nums[j];
                int l = 2;
                if(dp[j].containsKey(diff)) {
                    l = Math.max(l, dp[j].get(diff) + 1);
                }
                int dpL = dp[i].getOrDefault(diff, 0);
                dp[i].put(diff, Math.max(l, dpL));
                res = Math.max(res, l);
            }
        }
        return res;
    }
}