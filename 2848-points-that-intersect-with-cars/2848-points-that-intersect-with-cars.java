class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        boolean[] arr = new boolean[101];
        for(List<Integer> n : nums) {
            for(int i=n.get(0);i<=n.get(1);i++) {
                arr[i] = true;
            }
        }
        int res = 0;
        for(int i=0;i<arr.length;i++) {
            res += arr[i] ? 1 : 0;
        }
        return res;
    }
}