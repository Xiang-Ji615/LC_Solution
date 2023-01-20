class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            dfs(nums, res, new ArrayList<>(), i);
        }
        return new ArrayList(res);
    }
    
    void dfs(int[] nums, Set<List<Integer>> res, List<Integer> temp, int cur){
        if(temp.size() > 1)
            res.add(new ArrayList(temp));
        for(int i=cur;i<nums.length;i++){
            if(temp.size() == 0 || nums[i] >= temp.get(temp.size()- 1)){
                temp.add(nums[i]);
                dfs(nums, res, temp, i+1);
                temp.remove(temp.size() - 1);
            }
        } 
    }
}