class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<nums.length;i++) {
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            int cur = nums[i];
            int l = i+1, r = nums.length - 1;
            while(l < r) {
                int sum = cur + nums[l] + nums[r];
                if(sum == 0) {
                    res.add(Arrays.asList(cur, nums[l], nums[r]));
                    while(l < r && nums[l] == nums[l+1])
                        l++;
                    while(l < r && nums[r] == nums[r-1])
                        r--;
                }
                if(sum > 0)
                    r--;
                else
                    l++;
            }
        }
        return res;
    }
}