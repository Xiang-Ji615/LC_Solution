class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int res = 0, cnt = 0;
        for(int i=0;i<moves.length();i++) {
            if(moves.charAt(i) == 'L')
                res--;
            else if(moves.charAt(i) == 'R')
                res++;
            else
                cnt++;
        }
        return Math.abs(res) + cnt;
    }
}