class Solution {
    public long pickGifts(int[] gifts, int k) {
        Queue<Integer> q = new PriorityQueue<Integer>((a, b) -> b - a);
        for(int g : gifts)
            q.offer(g);
        while(k-- > 0) {
            q.offer((int)Math.sqrt(q.poll()));
        }
        long res = 0;
        while(!q.isEmpty()) {
            res += q.poll();
        }
        return res;
    }
}