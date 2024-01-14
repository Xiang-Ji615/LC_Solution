class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] cnt = new int[101];
        int max = 0, res = 0;
        for(int n : nums) {
            cnt[n]++;
            max = Math.max(max, cnt[n]);
        }
        for(int c : cnt) {
            res += (c == max ? c : 0);
        }
        return res;
    }
}