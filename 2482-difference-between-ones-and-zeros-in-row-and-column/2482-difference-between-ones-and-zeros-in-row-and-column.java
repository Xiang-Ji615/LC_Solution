class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int[] arr1 = new int[grid.length], arr2 = new int[grid[0].length];
        for(int i=0;i<grid.length;i++) {
            int sum = 0;
            for(int j=0;j<grid[0].length;j++) {
                sum += grid[i][j];
            }
            arr1[i] = sum;
        }
        for(int i=0;i<grid[0].length;i++) {
            int sum = 0;
            for(int j=0;j<grid.length;j++) {
                sum += grid[j][i];
            }
            arr2[i] = sum;
        }
        int[][] res = new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                res[i][j] = 2*arr1[i] + 2*arr2[j] - grid[0].length - grid.length;
            }
        }
        return res;
    }
}