class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<String> pSet = new HashSet<>(Arrays.asList(positive_feedback));
        Set<String> nSet = new HashSet<>(Arrays.asList(negative_feedback));
        for(int i=0;i<student_id.length;i++) {
            String r = report[i];
            int score = 0;
            for(String s : r.split("\\W+")) {
                if(pSet.contains(s)) {
                    score += 3;
                }else if(nSet.contains(s)) {
                    score--;
                }
            }
            map.putIfAbsent(student_id[i], score);
        }
        Queue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> a.getValue() == b.getValue() ? a.getKey() - b.getKey() : b.getValue() - a.getValue());
        maxHeap.addAll(map.entrySet());
        List<Integer> res = new ArrayList<>();
        while(!maxHeap.isEmpty() && k-- > 0) {
            res.add(maxHeap.poll().getKey());
        }
        return res;
    }
}