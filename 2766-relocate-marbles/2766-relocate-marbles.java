class Solution {
    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums) 
            map.put(n, map.getOrDefault(n, 0) + 1);
        for(int i=0;i<moveFrom.length;i++) {
            int val = map.getOrDefault(moveFrom[i], 0);
            map.remove(moveFrom[i]);
            if(map.containsKey(moveTo[i]))
                map.put(moveTo[i], map.get(moveTo[i]) + val);
            else
                map.put(moveTo[i], val);
        }
        List<Integer> res = new ArrayList<>();
        res.addAll(map.keySet());
        Collections.sort(res);
        return res;
    }
}