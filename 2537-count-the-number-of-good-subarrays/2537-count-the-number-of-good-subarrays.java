class Solution {
    public long countGood(int[] nums, int k) {
        long res = 0l;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0,j=0;j<nums.length;j++) {
            k-=map.getOrDefault(nums[j], 0);
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            while(k <= 0) {
                map.put(nums[i], map.get(nums[i]) - 1);
                k += map.get(nums[i++]);
            }
            res += i;
        }
        return res;
    }
}