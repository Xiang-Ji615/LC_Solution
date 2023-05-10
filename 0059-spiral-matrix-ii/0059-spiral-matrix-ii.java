class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int rowS = 0, rowE = n-1, colS =0, colE = n-1;
        int num = 1;
        while(rowS <= rowE && colS <= colE){
            for(int i=colS;i<=colE;i++){
                res[rowS][i] = num++;
            }
            rowS++;
            for(int i=rowS;i<=rowE;i++){
                res[i][colE] = num++;
            }
            colE--;
            for(int i=colE;i>=colS;i--){
                res[rowE][i] = num++;
            }
            rowE--;
            for(int i=rowE;i>=rowS;i--){
                res[i][colS] = num++;
            }
            colS++;
        }
        return res;
    }
}