class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int l = 0, r = piles.length - 1;
        int res = 0;
        while(l < r){
            res += piles[r-1];
            r-=2;
            l++;
        }
        return res;
    }
}