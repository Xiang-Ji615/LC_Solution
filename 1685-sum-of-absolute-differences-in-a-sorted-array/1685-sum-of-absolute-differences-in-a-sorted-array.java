class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int[] res = new int[nums.length];
        for(int i=1;i<nums.length;i++){
            res[i] += res[i-1] + i*(nums[i] - nums[i-1]);
        }
        int tmp = 0;
        for(int i=nums.length - 2,j=1;i>=0;i--,j++){
            tmp = tmp + (j * (nums[i+1] - nums[i]));
            res[i] += tmp;
        }
        return res;
    }
}