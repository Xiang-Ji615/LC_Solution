class Solution {
    public int characterReplacement(String s, int k) {
        int[] cnt = new int[26];
        int res = 0, max = 0, l = 0;
        for(int r=0;r<s.length();r++) {
            char c = s.charAt(r);
            max = Math.max(max, ++cnt[c - 'A']);
            while(r - l + 1 - max > k) {
                --cnt[s.charAt(l++) - 'A'];
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}