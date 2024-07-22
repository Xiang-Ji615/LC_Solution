class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        String[] res = new String[names.length];
        Queue<Map.Entry<Integer, String>> q = new PriorityQueue<>((a, b) -> b.getKey() - a.getKey());
        Map<Integer, String> map = new HashMap<>();
        for(int i=0;i<names.length;i++) {
            map.put(heights[i], names[i]);
        }
        q.addAll(map.entrySet());
        for(int i=0;i<res.length;i++) {
            res[i] = q.poll().getValue();
        }
        return res;
    }
}