class Solution {
    public int maxLength(List<String> arr) {
        List<Integer> dp = new ArrayList<>();
        dp.add(0);
        int res = 0;
        for(String s : arr){
            int mask = 0, dup = 0;
            for(char c : s.toCharArray()) {
                dup |= mask & 1 << (c - 'a');
                mask |= 1 << (c - 'a');
            }
            if(dup > 0)
                continue;
            for(int i=0;i<dp.size();i++){
                if((mask & dp.get(i)) > 0) continue;
                dp.add(dp.get(i) | mask);
                res = Math.max(res, Integer.bitCount(dp.get(dp.size() - 1)));
            }
        }
        return res;
    }
}