class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int l = 0, r = arr.length - 1;
        while(l < r) {
            int m1 = l + (r - l)/2;
            int m2 = m1 + 1;
            if(arr[m1] > arr[m2]) {
                r = m1;
            }else{
                l = m2;
            }
        }
        return l;
    }
}  