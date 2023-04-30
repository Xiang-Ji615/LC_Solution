class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int[] rows = new int[mat.length], cols = new int[mat[0].length];
        Map<Integer, Cell> map = new HashMap<>();
        for(int i=0;i<mat.length;i++) {
            for(int j=0;j<mat[0].length;j++) {
                map.put(mat[i][j], new Cell(i, j));
            }
        }
        for(int i=0;i<arr.length;i++) {
            Cell c = map.get(arr[i]);
            rows[c.r]++;
            cols[c.c]++;
            int tmp1 = Integer.MAX_VALUE, tmp2 = Integer.MAX_VALUE;
            if(rows[c.r] == mat[0].length || cols[c.c] == mat.length)
                return i;
        }
        return -1;
    }
    
    class Cell {
        int r, c;
        public Cell(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}