class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        dfs(nums, set, new ArrayList<>(), 0);
        return new ArrayList<>(set);
    }
    
    void dfs(int[] nums, Set<List<Integer>> res, List<Integer> lst, int cur) {
        if(lst.size() > 1)
            res.add(new ArrayList<>(lst));
        for(int i=cur;i<nums.length;i++) {
            if(lst.size() == 0 || (lst.size() > 0 && nums[i] >= lst.get(lst.size() - 1))) {
                lst.add(nums[i]);
                dfs(nums, res, lst, i + 1);
                lst.remove(lst.size() - 1);
            }
        }
    }
}