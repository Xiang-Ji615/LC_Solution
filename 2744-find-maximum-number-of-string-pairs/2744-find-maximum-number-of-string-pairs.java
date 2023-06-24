class Solution {
    public int maximumNumberOfStringPairs(String[] words) {
        Set<String> set = new HashSet<>();
        int res = 0;
        for(String w : words){
            if(set.contains(w)) {
                res++;
                set.remove(w);
            }
            StringBuilder sb = new StringBuilder();
            for(char c : w.toCharArray()) {
                sb.insert(0, c);
            }
            set.add(sb.toString());
        }
        return res;
    }
}