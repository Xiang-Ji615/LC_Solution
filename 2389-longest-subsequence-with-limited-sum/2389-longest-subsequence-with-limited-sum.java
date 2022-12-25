class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        int cnt = 0;
        for(int i=0;i<nums.length;i++) {
            tm.put(cnt += nums[i], i+1);
        }
        int[] res = new int[queries.length];
        for(int i=0;i<queries.length;i++) {
            res[i] = tm.floorEntry(queries[i]) == null ? 0 : tm.floorEntry(queries[i]).getValue();
        }
        return res;
    }
}