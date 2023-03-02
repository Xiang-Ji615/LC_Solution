class Solution {
    public int compress(char[] chars) {
        int l = 0, r = 0;
        while(r < chars.length){
            char c = chars[r];
            int cnt = 0;
            while(r < chars.length && c == chars[r]){
                r++;
                cnt++;
            }
            chars[l++] = c;
            if(cnt > 1){
                for(char n : String.valueOf(cnt).toCharArray()){
                    chars[l++] = n;
                }
            }
        }
        return l;
    }
}