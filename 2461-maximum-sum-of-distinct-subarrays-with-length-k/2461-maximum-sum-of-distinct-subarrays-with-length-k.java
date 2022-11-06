class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        long res = 0, sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if(i >= k-1) {
                if(map.size() == k) {
                    res = Math.max(res, sum);
                }
                sum -= nums[i - k + 1];
                map.put(nums[i - k + 1] , map.get(nums[i - k + 1]) - 1);
                if(map.get(nums[i - k + 1]) == 0)
                    map.remove(nums[i - k + 1]);
            }
        }
        return res;
    }
}