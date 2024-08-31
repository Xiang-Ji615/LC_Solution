class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        for(int i=0;i<nums.length;i++) {
            minHeap.add(new int[] { i, nums[i]});
        }
        for(int i=0;i<k;i++) {
            int[] cur = minHeap.poll();
            cur[1] *= multiplier;
            minHeap.offer(cur);
        
        }
        while(!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            nums[cur[0]] = cur[1];
        }
        return nums;
    }
}