class Solution {
    public long maxArrayValue(int[] nums) {
        int l = nums.length;
        long res = nums[l-1], sum = nums[l-1];
        for(int i=l-2;i>=0;i--) {
            if(nums[i] <= sum)
                sum += nums[i];
            else
                sum = nums[i];
            res = Math.max(res, sum);
        }
        return res;
    }
}