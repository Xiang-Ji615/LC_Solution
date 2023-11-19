class Solution {
    public int findMinimumOperations(String s1, String s2, String s3) {
        int n = 0, l = Math.min(s1.length(), Math.min(s2.length(), s3.length()));
        for(int i=0;i<l;i++) {
            if(s1.charAt(i) == s2.charAt(i) && s2.charAt(i) == s3.charAt(i)) {
                n++;
            }else{
                break;
            }
        }
        return n == 0 ? -1 : s1.length() + s2.length() + s3.length() - 3 * n;
    }
}