class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle.length() == 0)
            return 0;
        int i = 0, j = 0, sl = haystack.length(), pl = needle.length();
        int[] p = getP(needle);
        System.out.println(Arrays.toString(p));
        while(i < sl && j < pl){
            if(j == -1 || haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }else{
                j = p[j];
            }
        }
        if(j == pl){
            return i - j;
        }
        return -1;
    }
    
    int[] getP(String p){
        int[] res = new int[p.length() + 1];
        int i=0,j=-1;
        res[0] = -1;
        while(i < p.length()){
            if(j == -1 || p.charAt(i) == p.charAt(j)){
                i++;
                j++;
                res[i] = j;
            }else{
                j = res[j];
            }
        }
        return res;
    }
}