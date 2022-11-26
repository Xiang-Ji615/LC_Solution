class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[] dp = new int[startTime.length];
        List<Job> lst = new ArrayList<>();
        for(int i=0;i<startTime.length;i++){
            lst.add(new Job(startTime[i], endTime[i], profit[i]));
        }
        Collections.sort(lst, (a, b) -> a.et - b.et);
        dp[0] = lst.get(0).p;
        int res = 0;
        for(int i=1;i<startTime.length;i++){
            dp[i] = Math.max(lst.get(i).p, dp[i-1]);
            for(int j=i-1;j>=0;j--){
                if(lst.get(j).et <= lst.get(i).st){
                    dp[i] = Math.max(dp[i],  lst.get(i).p + dp[j]);
                    break;
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
    
    class Job{
        int st, et, p;
        public Job(int st, int et, int p){
            this.st = st;
            this.et = et;
            this.p = p;
        }
    }
}