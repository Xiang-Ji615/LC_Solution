class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length, l2 = nums2.length;
        if(l1 > l2){
            return findMedianSortedArrays(nums2, nums1);
        }
        int k = (l1 + l2 + 1)/2;
        int l = 0, r = l1;
        while(l < r){
            int m1 = l + (r - l)/2;
            int m2 = k - m1;
            if(nums1[m1] >= nums2[m2 - 1]){
                r = m1;
            }
            else{
                l = m1 + 1;
            }
        }
        int m1 = l, m2 = k - l;
        int c1 = Math.max(m1 <= 0 ? Integer.MIN_VALUE : nums1[m1 - 1], m2 <= 0 ? Integer.MIN_VALUE : nums2[m2 - 1]);
        if((l1 + l2) % 2 == 1)
            return c1;
        int c2 = Math.min(m1 >= nums1.length ? Integer.MAX_VALUE : nums1[m1], m2 >= nums2.length ? Integer.MAX_VALUE : nums2[m2]);
        return (c1 + c2)*0.5;
    }
}