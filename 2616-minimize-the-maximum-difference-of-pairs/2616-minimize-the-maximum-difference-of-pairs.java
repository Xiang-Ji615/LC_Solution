class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int l = nums.length, left = 0, right = nums[l-1] - nums[0];
        while(left < right) {
            int m = left + (right - left)/2, k =0;
            for(int i=1;i<l&&k<p;i++) {
                if(nums[i] - nums[i-1] <= m) {
                    k++;
                    i++;
                }
            }
            if(k >= p) {
                right = m;
            }else{
                left = m + 1;
            }
        }
        return left;
    }
}