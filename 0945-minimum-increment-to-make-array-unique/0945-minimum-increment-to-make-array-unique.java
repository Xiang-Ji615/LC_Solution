class Solution {
    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int res = 0, max = 0;
        for(int n : A) {
            res += Math.max(max - n, 0);
            max = Math.max(n, max) + 1;
        }
        return res;
    }
}