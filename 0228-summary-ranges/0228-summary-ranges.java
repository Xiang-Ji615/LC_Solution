class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return res;
        int n = nums[0];
        for(int i=1;i<nums.length;i++) {
            if(nums[i] != nums[i-1] + 1){ 
                if(n != nums[i-1])
                    res.add(n + "->" + nums[i-1]);
                else
                    res.add(n + "");
                n = nums[i];
            }
        }
        if(n == nums[nums.length - 1]) {
            res.add(n + "");
        }else{
            res.add(n + "->" + nums[nums.length -1]);
        }
        return res;
    }
}