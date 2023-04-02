class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums)
            map.put(n, map.getOrDefault(n, 0) + 1);
        Queue<Map.Entry<Integer, Integer>> q = new LinkedList<>();
        q.addAll(map.entrySet());
        List<List<Integer>> res = new ArrayList<>();
        while(!q.isEmpty()) {
            List<Integer> lst = new ArrayList<>();
            int size = q.size();
            for(int i=0;i<size;i++) {
                Map.Entry<Integer, Integer> e = q.poll();
                lst.add(e.getKey());
                e.setValue(e.getValue() - 1);
                if(e.getValue() > 0)
                    q.offer(e);
            }
            res.add(lst);
        }
        return res;
    }
}