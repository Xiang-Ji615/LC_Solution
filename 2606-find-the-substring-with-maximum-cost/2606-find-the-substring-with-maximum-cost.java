class Solution {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        int l = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(char c = 'a'; c <= 'z'; c++)
            map.put(c, c - 'a' + 1);
        for(int i=0;i<vals.length;i++) 
            map.put(chars.charAt(i), vals[i]);
        int res = 0, max = 0;
        for(int i=0;i<s.length();i++) {
            max = Math.max(map.get(s.charAt(i)), max + map.get(s.charAt(i)));
            res = Math.max(res, max);
        }
        return res;
    }
}