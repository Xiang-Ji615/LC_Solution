class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] cnt = new int[nums.length + 1];
        for(int n : nums){
            cnt[n]++;
        }
        int dup = Integer.MIN_VALUE, miss = Integer.MIN_VALUE;
        for(int i=1;i<=nums.length;i++){
            if(cnt[i] == 0) {
                miss = i;
            }
            if(cnt[i] > 1){
                dup = i;
            }
            if(miss != Integer.MIN_VALUE && dup != Integer.MIN_VALUE) {
                return new int[]{dup, miss};
            }
        }
        return new int[2];
    }
}