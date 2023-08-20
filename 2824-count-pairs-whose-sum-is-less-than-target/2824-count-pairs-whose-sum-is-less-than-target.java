class Solution {
    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        int l = 0, r = nums.size() - 1, res = 0;
        while(l < r) {
            if(nums.get(l) + nums.get(r) < target) {
                res += r - l;
                l++;
            }else{
                r--;
            }
        }
        return res;
    }
}