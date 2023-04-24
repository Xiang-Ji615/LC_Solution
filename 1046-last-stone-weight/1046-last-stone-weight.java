class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        for(int s : stones)
            q.offer(s);
        while(q.size() > 1) {
            int s1 = q.poll(), s2 = q.poll();
            if(s1 != s2) {
                q.offer(s1 - s2);
            }
        }
        return q.isEmpty() ? 0 : q.poll();
    }
}