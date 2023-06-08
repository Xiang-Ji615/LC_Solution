class Solution {
    public int countNegatives(int[][] grid) {
        int res = 0;
        for(int[] r : grid) {
            res += r.length - bs(r);
        }
        return res;
    }
    
    int bs(int[] row) {
        int l = 0, r = row.length;
        while(l < r) {
            int m = l + (r - l)/2;
            if(row[m] >= 0) {
                l = m + 1;
            }else{
                r = m;
            }
        }
        return l;
    }
}