class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] preSum = new int[words.length + 1];
        for(int i=1;i<=words.length;i++) {
            preSum[i] = preSum[i-1] + (isVowel(words[i-1]) ? 1 : 0);
        }
        int[] res = new int[queries.length];
        for(int i=0;i<queries.length;i++) {
            int[] cur = queries[i];
            res[i] = preSum[cur[1]+1] - preSum[cur[0]];
        }
        return res;
    }
    
    boolean isVowel(String s) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        return set.contains(s.charAt(0)) && set.contains(s.charAt(s.length() - 1));
    }
}