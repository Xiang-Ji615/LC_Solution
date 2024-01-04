class Solution {
    public int numberOfBeams(String[] bank) {
        int res = 0, prev = 0;
        for(int i=0;i<bank.length;i++){
            int cnt = 0;
            for(int j=0;j<bank[i].length();j++){
                if(bank[i].charAt(j) == '1'){
                    cnt++;
                }
            }
            res += prev * cnt;
            if(cnt != 0){
                prev = cnt;
            }
        }
        return res;
    }
}