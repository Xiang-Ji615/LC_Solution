class Solution {
    public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);
        int res = 0, tmp = 0, l = 0, r = tokens.length - 1;
        while(l <= r){
            if(P >= tokens[l]){
                P -= tokens[l++];
                res = Math.max(res, ++tmp);
            }else if(tmp > 0){
                P += tokens[r--];
                tmp--;
            }else{
                return res;
            }
        }
        return res;
    }
}