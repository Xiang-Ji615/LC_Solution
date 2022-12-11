class Solution {
    public int deleteGreatestValue(int[][] grid) {
        for(int[] r : grid){
            Arrays.sort(r);
        }
        int res = 0;
        for(int j=grid[0].length - 1;j>=0;j--) {
            int tmp = grid[0][j];
            for(int i=1;i<grid.length;i++) {
                tmp = Math.max(tmp, grid[i][j]);
            }
            res += tmp;
        }
        return res;
    }
}