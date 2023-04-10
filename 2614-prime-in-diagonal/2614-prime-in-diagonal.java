class Solution {
    public int diagonalPrime(int[][] nums) {
        int res = 0;
        for(int i=0;i<nums.length;i++) {
            if(isPrime(nums[i][i]))
                res = Math.max(res, nums[i][i]);
            if(isPrime(nums[nums.length - i - 1][i]))
                res = Math.max(res, nums[nums.length - 1 - i][i]);
        }
        return res;
    }
    
    boolean isPrime(int n) {
        if(n < 2) return false;
        for(int i=2;i<=Math.sqrt(n);i++) {
            if(n%i == 0)
                return false; 
        }
        return true;
    }
} 