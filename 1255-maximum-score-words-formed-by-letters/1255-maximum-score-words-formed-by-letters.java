class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        if(words == null || words.length == 0 || letters == null || letters.length == 0 || score == null || score.length == 0)
            return 0;
        int[] cnt = new int[26];
        for(char c : letters){
            cnt[c-'a']++;
        }
        int res = dfs(words, cnt, score, 0);
        return res;
    }
    
    int dfs(String[] words, int[] cnt, int[] score, int idx){
        int res = 0;
        for(int i=idx;i<words.length;i++){
            int tmp = 0;
            boolean isValid = true;
            for(char c : words[i].toCharArray()){
                cnt[c - 'a']--;
                tmp += score[c-'a'];
                if(cnt[c-'a'] < 0) isValid = false;
            }
            if(isValid){
                tmp += dfs(words, cnt, score, i+1);
                res = Math.max(res, tmp);
            }
            for(char c : words[i].toCharArray()){
                cnt[c-'a']++;
                tmp = 0;
            }
        }
        return res;
    }
}