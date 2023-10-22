class Solution {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        for(int i=0;i<nums.length;i++) {
            for(int j=i;j<nums.length;j++) {
                if(j - i >= indexDifference && Math.abs(nums[j] - nums[i]) >= valueDifference) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
} 