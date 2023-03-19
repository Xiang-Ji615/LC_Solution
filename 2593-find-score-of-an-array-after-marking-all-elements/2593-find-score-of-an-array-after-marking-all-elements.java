class Solution {
    public long findScore(int[] nums) {
        int l = nums.length;
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
           map.put(i, nums[i]);
        }
        Queue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getValue().equals(b.getValue()) ? a.getKey() - b.getKey() : a.getValue() - b.getValue());
        minHeap.addAll(map.entrySet());
        long res = 0;
        boolean[] visited = new boolean[l];
        while(!minHeap.isEmpty()) {
            Map.Entry<Integer, Integer> cur = minHeap.poll();
            int v = cur.getValue();
            int p = cur.getKey();
            if(!visited[p]) {
                res += v;
                visited[p] = true;
                if(p - 1 >= 0)
                    visited[p-1] = true;
                if(p + 1 < l)
                    visited[p+1] = true;
            }
        }
        return res;
    }
}