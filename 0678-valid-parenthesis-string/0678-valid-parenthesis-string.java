class Solution {
    public boolean checkValidString(String s) {
        int cMin = 0, cMax = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '('){
                cMin++;
                cMax++;
            }else if(c == ')'){
                cMax--;
                cMin = Math.max(0, cMin - 1);
            }else{
                cMax++;
                cMin = Math.max(0, cMin - 1);
            }
            if(cMax < 0)
                return false;
        }
        return cMin == 0;
    }
}