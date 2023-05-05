class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int res = 0, l = 0, tmp = 0;
        for(int r=0;r<s.length();r++) {
            char c = s.charAt(r);
            tmp += set.contains(c) ? 1 : 0;
            while(r - l + 1 > k) {
                tmp -= set.contains(s.charAt(l++)) ? 1 : 0;
            }
            res = Math.max(res, tmp);
        }
        return res;
    }
}