class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int l = 0, r = arr.length - 1;
        while(l < r) {
            if(arr[l] > arr[r]) {
                r--;
            }else{
                l++;
            }
        }
        return l;
    }
}  