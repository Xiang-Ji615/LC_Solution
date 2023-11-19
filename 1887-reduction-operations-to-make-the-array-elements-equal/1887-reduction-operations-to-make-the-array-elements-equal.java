class Solution {
    public int reductionOperations(int[] nums) {
        Map<Integer, Integer> tm = new TreeMap<>((a, b) -> b - a);
        for(int n : nums){
            tm.put(n, tm.getOrDefault(n, 0) + 1);
        }
        int res = 0, tmp = 0, cnt = 0;
        for(Map.Entry<Integer, Integer> e : tm.entrySet()){
            if(cnt++ == tm.entrySet().size() - 1)
                continue;
            tmp += e.getValue();
            res += tmp;
        }
        return res;
    }
}