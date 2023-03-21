class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long res = 0;
        int cnt = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i] == 0) {
                cnt++;
                res += cnt;
            }else{
                cnt = 0;
            }
        }
        return res;
    }
}