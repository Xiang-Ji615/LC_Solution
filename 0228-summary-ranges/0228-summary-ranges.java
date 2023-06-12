class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return res;
        for(int i=0;i<nums.length;i++) {
            int n = nums[i];
            while(i + 1 < nums.length && nums[i+1] == nums[i] + 1){
                i++;
            }
            if(nums[i] == n) 
                res.add(n + "");
            else
                res.add(n + "->" + nums[i]);
        }
        return res;
    }
}