class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for(char c : p.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int l = 0, cnt = map.keySet().size();
        for(int r=0;r<s.length();r++){
            char cur = s.charAt(r);
            if(map.containsKey(cur)){
                map.put(cur, map.get(cur) - 1);
                if(map.get(cur) == 0){
                    cnt--;
                }
                while(cnt == 0){
                    char lc = s.charAt(l);
                    if(r - l + 1 == p.length()){
                        res.add(l);
                    }
                    if(map.containsKey(lc)){
                        if(map.get(lc) == 0){
                            cnt++;
                        }
                        map.put(lc, map.get(lc) + 1);
                    }
                    l++;
                }
            }
        }
        return res;
    }
}