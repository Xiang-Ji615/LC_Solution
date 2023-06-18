class Solution {
    public int distanceTraveled(int mainTank, int additionalTank) {
        int res = 0;
        while(mainTank > 0){
            int used = Math.min(mainTank, 5);
            mainTank -= used;
            if(used == 5 && additionalTank > 0) {
                mainTank++;
                additionalTank--;
            }
            res += used * 10;
        }
        return res;
    }
}