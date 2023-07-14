class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int res = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for(int a : arr) {
            cnt.put(a, cnt.getOrDefault(a - difference, 0) + 1);
            res = Math.max(res, cnt.get(a));
        }
        return res;
    }
}