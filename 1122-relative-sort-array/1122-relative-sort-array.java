class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] cnt = new int[1001];
        for(int n : arr1) {
            cnt[n]++;
        }
        int[] res = new int[arr1.length];
        int cur = 0;
        for(int i=0;i<arr2.length;i++) {
            int c = cnt[arr2[i]];
            for(int j=0;j<c;j++) {
                res[cur++] = arr2[i];
                cnt[arr2[i]]--;
            }
        }
        for(int i=0;i<cnt.length;i++) {
            for(int j=0;j<cnt[i];j++) {
                res[cur++] = i;
            }
        }
        return res;
    }
}