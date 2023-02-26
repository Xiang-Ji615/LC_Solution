class Solution {
    public int[] leftRigthDifference(int[] nums) {
        int[] lSum = new int[nums.length], rSum = new int[nums.length];
        for(int i=1;i<nums.length;i++) {
            if(i == 1)
                lSum[i] = nums[0];
            else
                lSum[i] = lSum[i-1] + nums[i-1];
        }
        for(int i=nums.length - 2;i>=0;i--) {
            if(i == nums.length - 2)
                rSum[i] = nums[i+1];
            else
                rSum[i] = rSum[i+1] + nums[i +1];
        }
        for(int i=0;i<lSum.length;i++) {
            lSum[i] = Math.abs(lSum[i] - rSum[i]);
        }
        return lSum;
    }
}