class Solution {
    public int minimumPushes(String word) {
        int[] cnt = new int[26];
        for(char c : word.toCharArray()) {
            cnt[c - 'a']++;
        }
        Arrays.sort(cnt);
        int cur = 1, res = 0, c = 1;
        for(int i=25;i>=0;i--) {
            if(cur <= 8) {
                cur++;
            }else{
                cur=2;
                c++;
            }
            res += cnt[i] * c;
        }
        return res;
    }
}