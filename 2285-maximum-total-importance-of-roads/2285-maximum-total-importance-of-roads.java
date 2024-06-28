class Solution {
    public long maximumImportance(int n, int[][] roads) {
        long res = 0, cnt = 1;
        long[] nums = new long[n];
        for(int[] r : roads) {
            nums[r[0]]++;
            nums[r[1]]++;
        }
        Arrays.sort(nums);
        for(long num : nums) {
            res += num * (cnt++);
        }
        return res;
    }
}