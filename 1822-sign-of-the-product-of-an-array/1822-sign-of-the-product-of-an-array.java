class Solution {
    public int arraySign(int[] nums) {
        int res = 1;
         for(int n : nums){
            if(n < 0)
                res = -res;
            else if(n == 0)
                return 0;
        }
        return res;
    }
}