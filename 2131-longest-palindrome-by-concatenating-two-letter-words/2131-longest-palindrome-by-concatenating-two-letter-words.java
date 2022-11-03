class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        int res = 0;
        for(String w : words){
            String rev = w.charAt(1) + "" + w.charAt(0);
            if(map.containsKey(rev)){
                res += 4;
                map.put(rev, map.get(rev) - 1);
                if(map.get(rev) == 0)
                    map.remove(rev);
                continue;
            }
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        for(String k : map.keySet()){
            if(map.get(k) == 1 && k.charAt(0) == k.charAt(1)){
                res += 2;
                break;
            }
        }
        return res;
    }
}