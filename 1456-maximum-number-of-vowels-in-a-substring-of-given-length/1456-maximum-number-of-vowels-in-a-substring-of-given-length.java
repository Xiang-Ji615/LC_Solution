class Solution {
    public int maxVowels(String s, int k) {
        boolean[] arr = new boolean[26];
        arr['a' - 'a'] = true;
        arr['e' - 'a'] = true;
        arr['i' - 'a'] = true;
        arr['o' - 'a'] = true;
        arr['u' - 'a'] = true;
        int res = 0, l = 0, tmp = 0;
        for(int r=0;r<s.length();r++) {
            char c = s.charAt(r);
            tmp += arr[c - 'a'] ? 1 : 0;
            while(r - l + 1 > k) {
                tmp -= arr[s.charAt(l++) - 'a'] ? 1 : 0;
            }
            res = Math.max(res, tmp);
        }
        return res;
    }
} 