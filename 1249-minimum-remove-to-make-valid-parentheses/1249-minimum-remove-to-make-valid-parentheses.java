class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '(')
                cnt++;
            if(c == ')' && cnt == 0)
                continue;
            if(c == ')')
                cnt--;
            sb.append(c);
        }
        for(int i=sb.length() - 1;i>=0 && cnt>0;i--){
            if(sb.charAt(i) == '('){
                sb.deleteCharAt(i);
                cnt--;
            }
        }
        return sb.toString();
    }
}