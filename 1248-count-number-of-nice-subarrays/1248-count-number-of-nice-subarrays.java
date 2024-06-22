class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k- 1);
    }
    
    public int atMost(int[] nums, int k){
        int res = 0, l=0,n=nums.length;
        for(int r=0;r<n;r++){
            k-=nums[r]%2;
            while(k < 0)
                k+= nums[l++]%2;
            res += r-l+1;
        }
        return res;
    }
}