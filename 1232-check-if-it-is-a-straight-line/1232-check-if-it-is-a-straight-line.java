class Solution {
    
    public boolean checkStraightLine(int[][] coordinates) {
        Arrays.sort(coordinates, (a, b)->a[0] - b[0]);
        int dy = coordinates[1][1] - coordinates[0][1], dx = coordinates[1][0] - coordinates[0][0];
        int x = coordinates[0][0], y = coordinates[0][1];
        for(int i=2;i<coordinates.length;i++){
            if(dx * (coordinates[i][1] - y) != dy * (coordinates[i][0] - x))
                return false;
        }
        return true;
    }
}