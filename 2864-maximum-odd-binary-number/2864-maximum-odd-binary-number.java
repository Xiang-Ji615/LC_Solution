class Solution {
    public String maximumOddBinaryNumber(String s) {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for(char c : s.toCharArray()) {
            if(c == '1')
                cnt++;
        }
        for(int i=0;i<s.length() - 1;i++) {
            if(cnt > 1) {
                sb.append(1);
                cnt--;
            }else{
                sb.append(0);
            }
        }
        sb.append(cnt > 0 ? 1 : 0);
        return sb.toString();
    }
}