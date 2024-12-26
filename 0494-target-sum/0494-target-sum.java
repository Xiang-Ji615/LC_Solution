class Solution {
    
    int res = 0;
    
    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums, 0, target);
        return res;
    }
    
    void dfs(int[] nums, int cur, int target) {
        if(cur == nums.length) {
            if(target == 0)
                res++;
            return;
        }
        dfs(nums, cur + 1, target - nums[cur]);
        dfs(nums, cur + 1, target + nums[cur]);
    }
}