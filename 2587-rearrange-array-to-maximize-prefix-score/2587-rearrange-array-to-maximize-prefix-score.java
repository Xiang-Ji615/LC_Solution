class Solution {
    public int maxScore(int[] nums) {
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for(int n : nums) {
            maxHeap.offer(n);
        }
        long sum = 0;
        int res = 0;
        while(!maxHeap.isEmpty() && sum + maxHeap.peek() > 0) {
            sum += maxHeap.poll();
            res++;
        }
        return res;
    }
}