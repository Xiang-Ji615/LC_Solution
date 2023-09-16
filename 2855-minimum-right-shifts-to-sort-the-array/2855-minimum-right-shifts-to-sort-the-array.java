class Solution {
    public int minimumRightShifts(List<Integer> nums) {
        int min = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.size();i++) {
            map.put(nums.get(i), i);
            min = Math.min(min, nums.get(i));
        }
        int start = map.get(min);
        for(int i=0;i<nums.size() - 1;i++) {
            if(nums.get(start%nums.size()) > nums.get((start + 1)%nums.size()))
                return -1;
            start++;
        }
        return map.get(min) == 0 ? 0 : nums.size() - map.get(min);
    }
}