class Solution {
    public boolean buddyStrings(String A, String B) {
        if(A == null || B == null || A.length() != B.length())
            return false;
        int[] cnt = new int[26];
        int a = -1, b = -1, diff = 0;
        boolean res = false;
        for(int i=0;i<A.length();i++){
            char c = A.charAt(i);
            if(++cnt[c - 'a'] >= 2)
                res = true;
            if(A.charAt(i) != B.charAt(i)){
                diff++;
                if(a == -1)
                    a = i;
                else if(b == -1)
                    b = i;
            }
        }
        return (res == true && diff == 0) || (diff == 2 && A.charAt(a) == B.charAt(b) && A.charAt(b) == B.charAt(a));
    }
}