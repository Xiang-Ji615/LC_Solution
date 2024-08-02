class Solution {
    public int minSwaps(int[] nums) {
        int ones = 0, tmp = 0, onesInWindow = 0, l = nums.length;
        for(int n : nums){
            ones += n == 1 ? 1 : 0;
        }
        int[] nums2 = new int[l*2];
        for(int i=0;i<nums.length*2;i++){
            nums2[i] = nums[i%l];
        }
        for(int i=0;i<nums2.length;i++){
            if(i >= ones && nums2[i - ones] == 1)
                tmp--;
            if(nums2[i] == 1)
                tmp++;
            onesInWindow = Math.max(onesInWindow, tmp);
        }
        return ones - onesInWindow;
    }
}