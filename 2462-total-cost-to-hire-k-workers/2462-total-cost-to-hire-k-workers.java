class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int l = 0, r = costs.length - 1;
        Queue<Integer> minHeap = new PriorityQueue<>((a, b) -> costs[a] == costs[b] ? a - b : costs[a] - costs[b]);
        for (int i = 0; i < candidates && l <= r; i++) {
            minHeap.add(l++);
            if (l <= r) minHeap.add(r--);
        }

        long res = 0;
        while(k > 0) {
            int cur = minHeap.poll();
            if(l <= r && l < costs.length && r >= 0) {
                if(cur <= l)
                    minHeap.offer(l++);
                else
                    minHeap.offer(r--);
            }
            res += costs[cur];
            k--;
        }
        return res;
    }
}