class Solution {
    public long maxKelements(int[] nums, int k) {
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for(int n : nums) {
            maxHeap.offer(n);
        }
        long res = 0;
        while(!maxHeap.isEmpty() && k-- > 0) {
            int cur = maxHeap.poll();
            res += cur;
            maxHeap.offer(cur%3 == 0 ? cur/3 : cur/3+1);
        }
        return res;
    }
}