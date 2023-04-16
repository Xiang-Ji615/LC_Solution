class Solution {
    public int numWays(String[] words, String target) {
        int l = target.length();
        long mod = (long)1e9 + 7, res[] = new long[l + 1];
        res[0] = 1;
        for(int i=0;i<words[0].length();i++){
            int[] cnt = new int[26];
            for(String w : words){
                cnt[w.charAt(i) - 'a']++;
            }
            for(int j=l-1;j>=0;j--){
                res[j+1] += res[j] * cnt[target.charAt(j) - 'a'] % mod;
            }
        }
        return (int)(res[l]%mod);
    }
}