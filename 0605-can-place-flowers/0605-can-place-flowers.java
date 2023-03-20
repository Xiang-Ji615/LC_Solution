class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int[] nums = new int[flowerbed.length + 2];
        Arrays.fill(nums, 0);
        for(int i=0;i<flowerbed.length;i++) {
            nums[i+1] = flowerbed[i];
        }
        for(int i=1;i<nums.length - 1;i++) {
            if(nums[i] == 0 && nums[i-1] == 0 && nums[i+1] == 0) {
                nums[i] = 1;
                n--;
            }
        }
        return n <= 0;
    }
}