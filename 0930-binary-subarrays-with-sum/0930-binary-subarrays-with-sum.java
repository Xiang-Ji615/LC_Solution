class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int psum = 0, res = 0, cnt[] = new int[nums.length + 1];
        cnt[0] = 1;
        for(int n : nums) {
            psum += n;
            if(psum >= goal) {
                res += cnt[psum - goal];
            }
            cnt[psum]++;
        }
        return res;
    }
}