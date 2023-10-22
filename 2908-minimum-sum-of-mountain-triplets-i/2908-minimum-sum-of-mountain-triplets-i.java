class Solution {
    public int minimumSum(int[] nums) {
        int l = nums.length;
        int[] arr1 = new int[l], arr2 = new int[l];
        for(int i=0;i<nums.length;i++) {
            arr1[i] = i == 0 ? nums[i] : Math.min(arr1[i-1], nums[i]);
        }
        for(int i=nums.length - 1;i>=0;i--) {
            arr2[i] = i == nums.length - 1 ? nums[nums.length - 1] : Math.min(nums[i], arr2[i+1]);
        } 
        int res = Integer.MAX_VALUE;
        for(int i=1;i<nums.length-1;i++) {
             if(arr1[i-1]<nums[i] && arr2[i+1]<nums[i]){
                res = Math.min(res,arr1[i-1]+nums[i]+arr2[i+1]);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}