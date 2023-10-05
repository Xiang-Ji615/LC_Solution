class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums)
            map.put(n, map.getOrDefault(n, 0) + 1);
        for(Map.Entry<Integer, Integer> e : map.entrySet()) {
            if(e.getValue() > nums.length / 3)
                res.add(e.getKey());
        }
        return res;
    }
}