class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        Map<String, Integer> dp = new HashMap<>();
        return dfs(events, 0, 0, k, 0, dp);
    }
    
    int dfs(int[][] nums, int cur, int cnt, int k, int end, Map<String, Integer> dp){
        if(cnt == k || cur == nums.length)
            return 0;
        String key = cnt + "_" + end;
        Integer val = dp.get(key);
        if(val != null)
            return val;
        int max = dfs(nums, cur+1, cnt, k, end, dp);
        if(nums[cur][0] > end)
            max = Math.max(max, dfs(nums, cur+1, cnt+1, k, nums[cur][1], dp) + nums[cur][2]);
        dp.put(key, max);
        return max;
    }
}