class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while(l + 1 < r) {
            int m = l + (r - l)/2;
            if(nums[m] == target) {
                return m;
            }else if(nums[m] > target) {
                r = m;
            }else{
                l = m;
            }
        }
        if(nums[l] == target)
            return l;
        if(nums[r] == target)
            return r;
        return -1;
    }
}