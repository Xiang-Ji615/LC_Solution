class Solution {
    public boolean canFinish(int numCourses, int[][] ps) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Integer> cnt = new HashMap<>();
        for(int i=0;i<numCourses;i++) {
            cnt.put(i, 0);
        }
        for(int[] p : ps) {
            map.putIfAbsent(p[1], new HashSet<>());
            map.get(p[1]).add(p[0]);
            cnt.put(p[0], cnt.getOrDefault(p[0], 0) + 1);
        }
        Queue<Integer> q = new LinkedList<>();
        for(Map.Entry<Integer, Integer> e : cnt.entrySet()) {
            if(e.getValue() == 0){
                q.offer(e.getKey());
                numCourses--;
            }
        }
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int nei : map.getOrDefault(cur, new HashSet<>())) {
                cnt.put(nei, cnt.get(nei) - 1);
                if(cnt.get(nei) == 0) {
                    numCourses--;
                    q.offer(nei);
                }
            }
        }
        return numCourses == 0;
    }
}