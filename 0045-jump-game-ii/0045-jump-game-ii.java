class Solution {
    public int jump(int[] nums) {
        if(nums == null || nums.length <= 1)
            return 0;
        int gm = 0, cm = 0, res = 0;
        for(int i=0;i<nums.length;i++){
            cm = Math.max(cm, nums[i] + i);
            if(i == gm){
                gm = cm;
                res++;
                if(gm >= nums.length - 1)
                    return res;
            }
        }
        return res;
    }
}