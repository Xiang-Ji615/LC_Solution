class Solution {
    public int minOperations(List<Integer> nums, int k) {
        long target = (1L << k) - 1, tmp = 0L;
        int res = 0;
        do {
            int n = nums.get(nums.size() - 1);
            tmp |= (1L << (n - 1));
            nums.remove(nums.size() - 1);
            res++;
            k--;
        }while((target & tmp) != target);
        return res;
    }
}