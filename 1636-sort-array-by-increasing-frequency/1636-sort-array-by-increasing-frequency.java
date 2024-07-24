class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        Queue<Map.Entry<Integer, Integer>> q = new PriorityQueue<>((a, b) -> a.getValue() == b.getValue() ? b.getKey() - a.getKey() : a.getValue() - b.getValue());
        q.addAll(map.entrySet());
        int[] res = new int[nums.length];
        int cur = 0;
        while(!q.isEmpty()) {
            Map.Entry<Integer, Integer> e = q.poll();
            for(int i=0;i<e.getValue();i++) {
                res[cur++] = e.getKey();
            }
        }
        return res;
    }
}