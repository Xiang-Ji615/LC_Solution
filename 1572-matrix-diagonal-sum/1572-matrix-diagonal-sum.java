class Solution {
    public int diagonalSum(int[][] mat) {
        int l = 0, r = mat[0].length - 1;
        int res = 0;
        for(int i=0;i<mat.length;i++){
            if(l != r)
                res += mat[i][l++] + mat[i][r--];
            else
                res += (mat[i][l++] + mat[i][r--])/2;
        }
        return res;
    }
}