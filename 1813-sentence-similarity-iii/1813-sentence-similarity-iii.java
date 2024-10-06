class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] strs1 = sentence1.split(" "), strs2 = sentence2.split(" ");
        if(strs1.length > strs2.length)
            return areSentencesSimilar(sentence2, sentence1);
        int cur = 0;
        while(cur < strs1.length && strs1[cur].equals(strs2[cur])){
            cur++;
        }
        while(cur < strs1.length && strs1[cur].equals(strs2[strs2.length - strs1.length + cur])){
            cur++;
        }
        return cur == strs1.length;
    }
}