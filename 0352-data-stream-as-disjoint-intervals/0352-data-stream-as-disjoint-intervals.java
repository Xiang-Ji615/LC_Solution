class SummaryRanges {

    List<int[]> lst;
    /** Initialize your data structure here. */
    public SummaryRanges() {
        lst = new ArrayList<>();
    }
    
    public void addNum(int val) {
        int[] newInterval = {val, val};
        List<int[]> tmp = new ArrayList<>();
        int cur = 0;
        for(int i=0;i<lst.size();i++){
            if(newInterval[1] + 1 < lst.get(i)[0])
                tmp.add(lst.get(i));
            else if(newInterval[0] > lst.get(i)[1] + 1){
                tmp.add(lst.get(i));
                cur++;
            }
            else{
                newInterval[0] = Math.min(lst.get(i)[0], newInterval[0]);
                newInterval[1] = Math.max(lst.get(i)[1], newInterval[1]);
            }
        }
        tmp.add(cur, newInterval);
        lst = tmp;
    }
    
    
    
    public int[][] getIntervals() {
        int[][] res = new int[lst.size()][2];
        for(int i=0;i<lst.size();i++){
            res[i] = lst.get(i);
        }
        return res;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */