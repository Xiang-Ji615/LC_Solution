class Solution {
    public int[] getOrder(int[][] tasks) {
        int[][] nums = new int[tasks.length][];
        for(int i=0;i<tasks.length;i++){
            int[] t = tasks[i];
           nums[i] = new int[]{t[0], t[1], i};
        }
        Arrays.sort(nums, (a, b)->a[0] - b[0]);
        int[] res = new int[tasks.length];
        int cur = 0;
        Queue<int[]> minHeap = new PriorityQueue<>((a, b)->a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]);
        int t = 0, ai = 0, ti = 0;
        while(ai < tasks.length){
            while(ti < tasks.length && nums[ti][0] <= t){
                minHeap.offer(nums[ti++]);
            }
            if(minHeap.isEmpty()){
                t = nums[ti][0];
                continue;
            }
            int[] bestfit = minHeap.poll();
            res[ai++] = bestfit[2];
            t += bestfit[1];
        }
        return res;
    }
}