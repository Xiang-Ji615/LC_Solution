class Solution {
    public int maximumValue(String[] strs) {
        int res = 0;
        for(String s : strs) {
            int tmp = 0;
            for(char c : s.toCharArray()) {
                if(!Character.isDigit(c)) {
                    tmp = s.length();
                    break;
                }else{
                    tmp = tmp * 10 + (c - '0');
                }
            }
            res = Math.max(res, tmp);
        }
        return res;
    }
}