class Solution {
    public int minStoneSum(int[] piles, int k) {
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for(int p : piles)
            maxHeap.offer(p);
        while(!maxHeap.isEmpty() && k-- > 0){
            int cur = maxHeap.poll();
            maxHeap.offer(cur - cur/2);
        }
        int res = 0;
        while(!maxHeap.isEmpty())
            res += maxHeap.poll();
        return res;
    }
}