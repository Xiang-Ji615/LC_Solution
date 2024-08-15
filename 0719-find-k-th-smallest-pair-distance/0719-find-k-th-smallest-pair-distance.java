class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int[] cnt = new int[1000001];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int abs = Math.abs(nums[i] - nums[j]);
                cnt[abs]++;
            }
        }
        int sum = 0;
        for(int i=0;i<cnt.length;i++){
            sum += cnt[i];
            if(sum >= k)
                return i;
        }
        return 0;
    }
}