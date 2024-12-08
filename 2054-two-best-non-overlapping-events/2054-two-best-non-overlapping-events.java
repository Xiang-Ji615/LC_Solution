class Solution {
    public int maxTwoEvents(int[][] events) {
        int res = 0, max = 0;
        Arrays.sort(events, (a, b)->a[0] - b[0]);
        Queue<int[]> q = new PriorityQueue<>((a, b)->a[1] - b[1]);
        for(int[] e : events){
            while(!q.isEmpty() && q.peek()[1] < e[0]){
                max = Math.max(max, q.poll()[2]);
            }
            res = Math.max(res, max + e[2]);
            q.offer(e);
        }
        return res;
    }
}