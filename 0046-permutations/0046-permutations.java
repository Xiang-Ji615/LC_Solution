class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        dfs(res, visited, nums, new ArrayList<>());
        return res;
    }
    
    void dfs(List<List<Integer>> res, Set<Integer> visited, int[] nums, List<Integer> lst) {
        if(lst.size() == nums.length) {
            res.add(new ArrayList<>(lst));
            return;
        }
        for(int i=0;i<nums.length;i++) {
            if(visited.add(nums[i])) {
                lst.add(nums[i]);
                dfs(res, visited, nums, lst);
                lst.remove(lst.size() - 1);
                visited.remove(nums[i]);
            }
        }
    }
}