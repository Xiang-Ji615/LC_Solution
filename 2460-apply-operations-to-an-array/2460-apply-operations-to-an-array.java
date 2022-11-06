class Solution {
    public int[] applyOperations(int[] nums) {
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<nums.length-1;i++){
            if(nums[i] == 0)
                continue;
            if(nums[i] == nums[i+1]){
                q.offer(2*nums[i]);
                i++;
            }else{
                q.offer(nums[i]);
            }
        }
        if(nums[nums.length - 1] != nums[nums.length - 2])
            q.offer(nums[nums.length - 1]);
        int[] res = new int[nums.length];
        int cur = 0;
        while(!q.isEmpty()) {
            res[cur++] = q.poll();
        }
        return res;
    }
}