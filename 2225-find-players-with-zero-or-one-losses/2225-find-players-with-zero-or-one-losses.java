class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int[] m : matches) {
            map.put(m[0], map.getOrDefault(m[0], 0));
            map.put(m[1], map.getOrDefault(m[1], 0) - 1);
        }
        System.out.println(map);
        TreeMap<Integer, TreeSet<Integer>> m = new TreeMap<>((a, b) -> b - a);
        for(Map.Entry<Integer, Integer> e : map.entrySet()) {
            m.putIfAbsent(e.getValue(), new TreeSet<>());
            m.get(e.getValue()).add(e.getKey());
        }
        res.add(new ArrayList<>(m.getOrDefault(0, new TreeSet<>())));
        res.add(new ArrayList<>(m.getOrDefault(-1, new TreeSet<>())));
        return res;
    }
}