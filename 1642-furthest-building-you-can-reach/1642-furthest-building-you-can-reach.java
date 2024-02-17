class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        for(int i=0;i<heights.length-1;i++){
            int d = heights[i+1] - heights[i];
            if (d > 0)
                minHeap.add(d);
            if (minHeap.size() > ladders)
                bricks -= minHeap.poll();
            if (bricks < 0)
                return i;
        }
        return heights.length - 1;
    }
}