class Solution {
    public int maxConsecutiveAnswers(String s, int k) {
        int res = 0, max = 0, cnt[] = new int[128];
        for(int i=0;i<s.length();i++){
            max = Math.max(max, ++cnt[s.charAt(i)]);
            if(res - max < k)
                res++;
            else
                cnt[s.charAt(i - res)]--;
        }
        return res;
    }
}