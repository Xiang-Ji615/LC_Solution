class Solution {
    public int eraseOverlapIntervals(int[][] arr) {
        if(arr == null || arr.length == 0)
            return 0;
        Arrays.sort(arr, (a, b) -> a[1] - b[1]);
        int[] first = arr[0];
        int cnt = 0;
        for(int i=1;i<arr.length;i++) {
            int[] cur = arr[i];
            if(cur[0] >= first[1]) {
                first[1] = Math.max(first[1], cur[1]);
                cnt++;
            }
        }
        return arr.length - 1 - cnt;
    }
}