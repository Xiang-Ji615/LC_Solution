class Solution {
    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : chars.toCharArray()) 
            map.put(c, map.getOrDefault(c, 0) + 1);
        int res = 0;
        for(String w : words) {
            Map<Character, Integer> m = new HashMap<>();
            for(char c : w.toCharArray()) {
                m.put(c, m.getOrDefault(c, 0) + 1);
            }
            boolean match = true;
            for(Map.Entry<Character, Integer> e : m.entrySet()) {
                if(e.getValue() > map.getOrDefault(e.getKey(), 0)){
                    match = false;
                    break;
                }
            }
            res += match ? w.length() : 0;
        }
        return res;
    }
}