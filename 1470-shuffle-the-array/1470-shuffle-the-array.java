class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[nums.length];
        int cur = 0;
        for(int i=0;i<n;i++){
            res[cur++] = nums[i];
            res[cur++] = nums[i+n];
        }
        return res;
    }
}