class Solution {
    public boolean canCross(int[] stones) {
        if(stones == null || stones.length == 0)
            return true;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int n : stones){
            map.put(n, new HashSet<>());
        }
        map.get(stones[0]).add(0);
        for(int i=0;i<stones.length;i++){
            int cur = stones[i];
            Set<Integer> set = new HashSet<>(map.get(cur));
            for(int n : set){
                for(int d=-1;d<=1;d++){
                    int next = cur + n + d;
                    if(map.containsKey(next)){
                        map.get(next).add(n + d);
                    }
                }
            }
        }
        return !map.get(stones[stones.length - 1]).isEmpty();
    }
}