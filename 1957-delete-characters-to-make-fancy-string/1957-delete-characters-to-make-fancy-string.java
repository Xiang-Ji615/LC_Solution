class Solution {
    public String makeFancyString(String s) {
        if(s.length() < 3)
            return s;
        StringBuilder sb = new StringBuilder();
        int l = 0;
        for(int r = 0;r<s.length();r++){
            char c = s.charAt(l);
            while(r < s.length() && s.charAt(r) == c){
                r++;
            }
            for(int j=0;j<Math.min(2, r - l );j++){
                sb.append(s.charAt(l));
            }
            l = r;
        }
        if(s.charAt(s.length() - 1) != s.charAt(s.length() - 2))
            sb.append(s.charAt(s.length() - 1));
        return sb.toString();
    }
}