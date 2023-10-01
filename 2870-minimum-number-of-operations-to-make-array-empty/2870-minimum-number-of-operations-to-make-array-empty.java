class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums)
            map.put(n, map.getOrDefault(n, 0) + 1);
        int res = 0;
        for(int v : map.values()) {
            if(v < 2)
                return -1;
            res += v/3;
            if(v%3 > 0)
                res++;
        }
        return res;
    }
}