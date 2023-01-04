class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int t : tasks) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        // Queue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        // maxHeap.addAll(map.entrySet());
        // int res = 0;
        // while(!maxHeap.isEmpty()) {
        //     Map.Entry<Integer, Integer> e = maxHeap.poll();
        //     if(e.getValue() < 2)
        //         return -1;
        //     res += (e.getValue() + 2)/3;
        // }
        int res = 0;
        for(Map.Entry<Integer, Integer> e : map.entrySet()) {
            if(e.getValue() < 2)
                return -1;
            res += (e.getValue() + 2)/3;
        }
        return res;
    }
}