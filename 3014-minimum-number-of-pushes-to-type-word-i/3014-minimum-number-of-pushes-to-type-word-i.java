class Solution {
    public int minimumPushes(String word) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : word.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int cnt = 0, val = 0, res = 0;
        Queue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        maxHeap.addAll(map.entrySet());
        while(!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> e = maxHeap.poll();
            if(cnt % 8 == 0)
                val++;
            cnt++;
            res += val;
        }
        return res;
    }
}