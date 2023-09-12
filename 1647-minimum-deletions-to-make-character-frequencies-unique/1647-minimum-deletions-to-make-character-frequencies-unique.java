class Solution {
    public int minDeletions(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.addAll(map.values());
        int res = 0;
        while(!maxHeap.isEmpty()) {
            int cur = maxHeap.poll();
            if(maxHeap.isEmpty())
                return res;
            if(cur == maxHeap.peek()) {
                if(cur > 1) {
                    maxHeap.offer(--cur);
                }
                res++;
            }
        }
        return res;
    }
}