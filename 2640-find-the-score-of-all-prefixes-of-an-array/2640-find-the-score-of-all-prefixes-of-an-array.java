class Solution {
    public long[] findPrefixScore(int[] nums) {
        long[] res = new long[nums.length];
        int max = nums[0];
        long t = 0;
        for(int i=0;i<nums.length;i++) {
            max = Math.max(max, nums[i]);
            nums[i] += max;
            t += nums[i];
            res[i] = t;
        }
        return res;
    }
}