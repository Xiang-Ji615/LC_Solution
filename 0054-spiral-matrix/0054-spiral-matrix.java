class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0)
            return res;
        int rMin = 0, cMin = 0, rMax = matrix.length-1, cMax = matrix[0].length - 1;
        while(rMin <= rMax && cMin <= cMax){
            for(int i=cMin;i<=cMax;i++){
                res.add(matrix[rMin][i]);
            }
            rMin++;
            for(int i=rMin;i<=rMax;i++){
                res.add(matrix[i][cMax]);
            }
            cMax--;
            if(rMin <= rMax){
                for(int i=cMax;i>=cMin;i--){
                    res.add(matrix[rMax][i]);
                }
            }
            rMax--;
            if(cMin <= cMax){
                for(int i=rMax;i>=rMin;i--){
                    res.add(matrix[i][cMin]);
                }
            }
            cMin++;
        }
        return res;
    }
}