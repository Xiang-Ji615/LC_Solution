class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int res = 0;
        for(int i=Math.max(10, low);i<=high;i++) {
            String s = String.valueOf(i);
            int l = 0, r = s.length() - 1, lCnt = 0, rCnt = 0;
            if(s.length() % 2 != 0)
                continue;
            while(l < r) {
                lCnt+=s.charAt(l++) - '0';
                rCnt+=s.charAt(r--) - '0';
            }
            if(lCnt == rCnt) {
                // System.out.println(i);
                res++;
            }
                
        }
        return res;
    }
}