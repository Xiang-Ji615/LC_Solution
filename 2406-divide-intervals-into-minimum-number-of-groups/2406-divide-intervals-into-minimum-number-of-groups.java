class Solution {
    public int minGroups(int[][] intervals) {
        int res = 0, max = 0;
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        Queue<Integer> q = new PriorityQueue<>();
        q.offer(1000001);
        for(int[] i : intervals) {
            if(max >= i[0] && q.peek() >= i[0]){
                res++;
            }else{
                q.poll();
                max = i[1];
            }
            q.offer(i[1]);
        }
        return res+1;
    }
}