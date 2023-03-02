class Solution {
    public int compress(char[] chars) {
        int l = 0, r = 0;
        while(r < chars.length) {
            int cnt = 0;
            char c = chars[r];
            while(r < chars.length && c == chars[r]) {
                cnt++;
                r++;
            }
            chars[l++] = c;
            if(cnt > 1) {
                for(char n : String.valueOf(cnt).toCharArray()) {
                    chars[l++] = n;
                }
            }
        }
        return l;
    }
}