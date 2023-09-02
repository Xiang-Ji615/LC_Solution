class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Set<String> set = new HashSet<>();
        for(String d : dictionary)
            set.add(d);
        int[] dp = new int[s.length() + 1];
        for(int i=1;i<dp.length;i++) {
            dp[i] = dp[i-1] + 1;
            for(int j=i-1;j>=0;j--) {
                String str = s.substring(j, i);
                if(set.contains(str)) {
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
        }
        return dp[dp.length - 1];
    }
}