class Solution {
    public int minPatches(int[] nums, int n) {
        if(n <= 0) return 0;
        long sum = 0;
        int res = 0;
        for(int i=0;i<nums.length;i++){
            int k = nums[i];
            while(k > sum + 1 && sum < n){
                res += 1;
                sum += (sum + 1);
            }
            sum += k;
        }
        if(sum < n){
            while(sum < n){
                res += 1;
                sum += (sum + 1);
            }
        }
        return res;
    }
}