class Solution {
    public int captureForts(int[] forts) {
        int res = 0, l = 0;
        for(int r=0;r<forts.length;r++) {
            if(forts[r] != 0) {
                if(forts[l] == -forts[r])
                    res = Math.max(res, r - l - 1);
                l = r;
            }
        }
        return res;
    }
}