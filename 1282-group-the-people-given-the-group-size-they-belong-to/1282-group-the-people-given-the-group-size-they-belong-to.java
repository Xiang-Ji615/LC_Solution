class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        for(int i=0;i<groupSizes.length;i++) {
            map.putIfAbsent(groupSizes[i], new LinkedList<>());
            map.get(groupSizes[i]).offer(i);
        }
        System.out.println(map);
        for(Map.Entry<Integer, Queue<Integer>> e : map.entrySet()) {
            Queue<Integer> q = e.getValue();
            int k = e.getKey(), size = q.size();
            for(int i=0;i<size/k;i++) {
                List<Integer> lst = new ArrayList<>();
                for(int j=0;j<k;j++) {
                    lst.add(q.poll());
                }
                res.add(lst);
            }
        }
        return res;
    }
}