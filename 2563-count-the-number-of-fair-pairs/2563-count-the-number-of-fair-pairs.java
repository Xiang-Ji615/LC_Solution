class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        long res = 0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++) {
            int cur = nums[i];
            res += bsUpper(nums, upper, cur, i) - bsLower(nums, lower, cur, i);
        }
        return res;
    }
    
    int bsLower(int[] nums, int lower, int cur, int i) {
        int l = i + 1, r = nums.length;
        while(l < r) {
            int m = l + (r - l)/2;
            if(nums[m] < lower - cur) {
                l = m + 1;
            }else {
                r = m;
            }
        }
        return l;
    }
    
    int bsUpper(int[] nums, int upper, int cur, int i) {
        int l = i + 1, r = nums.length;
        while(l < r) {
            int m = l + (r - l)/2;
            if(nums[m] > upper - cur) {
                r = m;
            }else {
                l = m + 1;
            }
        }
        return l;
    }
}