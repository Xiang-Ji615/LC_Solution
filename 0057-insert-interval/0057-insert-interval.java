class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals == null || newInterval == null)
            return new int[0][];
        List<int[]> lst = new ArrayList<>();
        for(int[] i : intervals)
            lst.add(i);
        lst.add(newInterval);
        Collections.sort(lst, (a, b)->a[0] - b[0]);
        List<int[]> resLst = new ArrayList<>();
        int[] first = lst.get(0);
        for(int i=1;i<lst.size();i++){
            int[] cur = lst.get(i);
            if(Math.max(first[0], cur[0]) <= Math.min(first[1], cur[1]))
                first[1] = Math.max(first[1], cur[1]);
            else{
                resLst.add(first);
                first = cur;
            }
        }
        resLst.add(first);
        int[][] res = new int[resLst.size()][2];
        for(int i=0;i<resLst.size();i++){
            res[i] = resLst.get(i);
        }
        return res;
    }
}