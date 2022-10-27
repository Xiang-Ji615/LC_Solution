class Solution {
    public int largestOverlap(int[][] A, int[][] B) {
        int r = A.length, c = A[0].length;
        Map<String, Integer> map = new HashMap<>();
        List<int[]> aList = new ArrayList<>(), bList = new ArrayList<>();
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(A[i][j] == 1) aList.add(new int[]{i, j});
                if(B[i][j] == 1) bList.add(new int[]{i, j});
            }
        }
        
        for(int[] aArr : aList){
            for(int[] bArr : bList){
                String key = (aArr[0] - bArr[0]) + " " + (aArr[1] - bArr[1]);
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }
        
        int res = 0;
        for(int val : map.values()){
            res = Math.max(res, val);
        }
        return res;
    }
}