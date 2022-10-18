class Solution {
    public String countAndSay(int n) {
        if(n == 1)
            return "1";
        String res = "1";
        for(int i=1;i<n;i++){
            res = helper(res);
        }
        return res; 
    }
    
    String helper(String in){
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        char pre = in.charAt(0);
        for(int i=1;i<in.length();i++){
            if(pre != in.charAt(i)){
                sb.append(cnt);
                sb.append(pre);
                cnt = 1;
                pre = in.charAt(i);
            }else{
                cnt++;
            }
        }
        sb.append(cnt);
        sb.append(pre);
        return sb.toString();
    }
}