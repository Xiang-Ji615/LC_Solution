class Solution {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        Map<String, Queue<Node>> map = new HashMap<>();
        Map<String, Long> cntMap = new HashMap<>();
        long max = 0;
        for(int i=0;i<creators.length;i++){
            map.putIfAbsent(creators[i], new PriorityQueue<>((a, b) -> a.view == b.view ? a.id.compareTo(b.id) : b.view - a.view));
            map.get(creators[i]).offer(new Node(ids[i], views[i]));
            cntMap.put(creators[i], cntMap.getOrDefault(creators[i], 0L) + views[i]);
            max = Math.max(max, cntMap.get(creators[i]));
        }
        List<List<String>> res = new ArrayList<>();
        for(Map.Entry<String, Long> e : cntMap.entrySet()) {
            if(e.getValue() == max) {
                res.add(Arrays.asList(e.getKey(), map.get(e.getKey()).poll().id));
            }
        }
        return res;
    }
    
    class Node {
        String id;
        int view;
        public Node(String id, int view) {
            this.id = id;
            this.view = view;
        }
        
        @Override
        public String toString() {
            return id + "," + view;
        }
    }
}