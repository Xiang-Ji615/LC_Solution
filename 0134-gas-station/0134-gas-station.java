class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int res = 0, r = 0, cnt = 0;
        for(int i=0;i<gas.length;i++){
            r += gas[i] - cost[i];
            if(r < 0){
                cnt += r;
                r = 0;
                res = i + 1;
            }
        }
        return r + cnt < 0 ? -1 : res;
    }
}