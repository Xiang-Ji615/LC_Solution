class Solution {
    public int alternatingSubarray(int[] nums) {
        int l = nums.length, res = 0, j = 0;
        for(int i=0;i<l;i++) {
            for(j=i+1;j<l && nums[j] == nums[i] + (j - i)%2;j++) {
                res = Math.max(res, j - i + 1);
            }
        }
        return res> 1 ? res : -1;
    }
}