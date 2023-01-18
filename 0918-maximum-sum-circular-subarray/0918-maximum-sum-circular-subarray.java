class Solution {
    public int maxSubarraySumCircular(int[] A) {
        int max = 0, gMax = Integer.MIN_VALUE, min = 0, gMin = Integer.MAX_VALUE, sum = 0;
        for(int n : A){
            max = Math.max(n, max + n);
            gMax = Math.max(gMax, max);
            min = Math.min(n, min + n);
            gMin = Math.min(gMin, min);
            sum += n;
        }
        return max > 0 ? Math.max(gMax, sum - gMin) : gMax;
    }
}