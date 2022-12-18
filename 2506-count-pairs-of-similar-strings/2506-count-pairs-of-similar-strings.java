class Solution {
    public int similarPairs(String[] words) {
        Map<Integer, Integer> map = new HashMap<>();
        for(String s : words) {
            int tmp = 0;
            for(char c : s.toCharArray()) {
                tmp |= 1 << c - 'a';
            }
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }
        int res = 0;
        for(Map.Entry<Integer, Integer> e : map.entrySet()) {
            if(e.getValue() > 1) {
                res += e.getValue() * (e.getValue() - 1)/2;
            }
        }
        return res;
    }
}