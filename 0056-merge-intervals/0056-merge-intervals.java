class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] prev = intervals[0];
        List<int[]> lst = new ArrayList<>();
        for(int i=1;i<intervals.length;i++) {
            int[] cur = intervals[i];
            if(Math.max(prev[0], cur[0]) <= Math.min(prev[1], cur[1])) {
                prev[1] = Math.max(cur[1], prev[1]);
            }else{
                lst.add(prev);
                prev = cur;
            }
        }
        lst.add(prev);
        int[][] res = new int[lst.size()][2];
        for(int i=0;i<lst.size();i++)
            res[i] = lst.get(i);
        return res;
    }
}