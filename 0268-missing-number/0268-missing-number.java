class Solution {
    public int missingNumber(int[] nums) {
        boolean[] cnt = new boolean[nums.length + 1];
        for(int n : nums)
            cnt[n] = true;
        for(int i=0;i<cnt.length;i++) {
            if(!cnt[i])
                return i;
        }
        return -1;
    }
}