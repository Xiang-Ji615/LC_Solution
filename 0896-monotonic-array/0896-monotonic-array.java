class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean isInc = true, isDec = true;
        for(int i=1;i<nums.length;i++) {
            isInc &= nums[i-1] <= nums[i];
            isDec &= nums[i-1] >= nums[i];
        }
        return isInc || isDec;
    }
}