class Solution {
    public int minDifference(int[] nums) {
        int l = nums.length, res = Integer.MAX_VALUE;
        if(nums.length < 5)
            return 0;
        Arrays.sort(nums);
        for(int i=0;i<4;i++){
            res = Math.min(res, nums[l - 4 + i] - nums[i]);
        }
        return res;
    }
}