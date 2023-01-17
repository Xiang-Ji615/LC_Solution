class Solution {
    public int minFlipsMonoIncr(String s) {
        char[] sArr = s.toCharArray();
        int flipCnt = 0, oneCnt = 0;
        for(int i=0;i<sArr.length;i++) {
            if(sArr[i] == '0') {
                if(oneCnt == 0)
                    continue;
                else
                    flipCnt++;
            }else{
                oneCnt++;
            }
            flipCnt = Math.min(flipCnt, oneCnt);
        }
        return flipCnt;
    }
}