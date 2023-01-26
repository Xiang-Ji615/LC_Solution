class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        if(flights == null || flights.length == 0)
            return 0;
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for(int[] f : flights){
            map.putIfAbsent(f[0], new HashMap<>());
            map.get(f[0]).put(f[1], f[2]);
        }
        int [] stopLeft = new int[n];
        Queue<int[]> minHeap = new PriorityQueue<>((a, b)->a[0] - b[0]);
        minHeap.offer(new int[]{0, src, K+1});
        while(!minHeap.isEmpty()){
            int[] cur = minHeap.poll();
            if(cur[2] < 0)
                continue;
            if(cur[1] == dst){
                return cur[0];
            }
            if(stopLeft[cur[1]] != 0 && stopLeft[cur[1]] >= cur[2]){
                continue;
            }
            stopLeft[cur[1]] = cur[2];
            for(Map.Entry<Integer, Integer> e : map.getOrDefault(cur[1], new HashMap<>()).entrySet()){
                minHeap.offer(new int[]{cur[0] + e.getValue(), e.getKey(), cur[2] - 1});
            }
        }
        return -1;
    }
}