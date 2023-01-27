class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        if(words == null || words.length == 0){
            System.out.println("Empty");
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        Arrays.sort(words, (a, b)->a.length() - b.length());
        Set<String> preWords = new HashSet<>();
        for(int i=0;i<words.length;i++){
            if(canMerge(words[i], preWords)){
                res.add(words[i]);
            }
            preWords.add(words[i]);
        }
        return res;
    }
    
    boolean canMerge(String words, Set<String> wordDict){
        if(wordDict.isEmpty())
            return false;
        boolean[] dp = new boolean[words.length()+1];
        dp[0] = true;
        for(int i=1;i<=words.length();i++){
            for(int j=0;j<i;j++){
                if(!dp[j]) continue;
                if(dp[j] && wordDict.contains(words.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length - 1];
    }
    
    
}