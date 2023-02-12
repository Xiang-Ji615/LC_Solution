class Solution {
    public long findTheArrayConcVal(int[] nums) {
        long res = 0;
        int l = 0, r = nums.length - 1;
        while(l <= r) {
            StringBuilder sb = new StringBuilder();
            if(l != r) {
                sb.append(nums[l++]);
                sb.append(nums[r--]);
            }else{
                sb.append(nums[l++]);
            }
            res += Long.parseLong(sb.toString());
        }
        return res;
    }
}