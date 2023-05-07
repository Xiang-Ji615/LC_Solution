class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        int[] res = new int[nums.length];
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums)
            map.put(n, map.getOrDefault(n, 0) + 1);
        for(int i=0;i<nums.length;i++) {
            set.add(nums[i]);
            map.put(nums[i], map.get(nums[i]) - 1);
            if(map.get(nums[i]) == 0)
                map.remove(nums[i]);
            res[i] = set.size() - map.entrySet().size();
        }
        return res;
    }
}