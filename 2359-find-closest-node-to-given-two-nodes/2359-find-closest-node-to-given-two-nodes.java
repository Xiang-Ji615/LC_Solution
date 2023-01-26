class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        Map<Integer, Integer> map = new HashMap<>();
        int idx = node1, res = -1, min = Integer.MAX_VALUE, dist = 0;
        while(!map.containsKey(idx) && idx>-1) {
            map.put(idx, dist++);
            idx = edges[idx];
        }
        idx = node2;
        dist = 0;
        Set<Integer> set = new HashSet<>();
        while(!set.contains(idx) && idx > -1){
            if(map.containsKey(idx)){
                int cur = Math.max(dist, map.get(idx));
                if(res == -1 || cur <= min){
                    res = cur == min ? Math.min(res, idx) : idx;
                    min = cur;
                }
            }
            dist++;
            set.add(idx);
            idx = edges[idx];
        }
        return res;
    }
}