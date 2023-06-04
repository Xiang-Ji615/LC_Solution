class Solution {
    public int semiOrderedPermutation(int[] nums) {
        int l = nums.length, a = 0, b = 0;
        for(int i=0;i<l;i++) {
            if(nums[i] == 1) 
                a = i;
            else if(nums[i] == l)
                b = i;
        }
        return a + (l - 1 - b) - (a > b ? 1 : 0);
    }
}