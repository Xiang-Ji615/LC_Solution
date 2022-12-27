class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        int res = 0;
        for(int i=0;i<capacity.length;i++){
            int remain = capacity[i] - rocks[i];
            if(remain == 0)
                res++;
            else
                minHeap.offer(remain);
        }
        while(!minHeap.isEmpty() && additionalRocks > 0) {
            int cur = minHeap.poll();
            if(additionalRocks >= cur){
                additionalRocks -= cur;
                res++;
            }
        }
        return res;
    }
}