class Solution {
    public int equalPairs(int[][] grid) {
        StringBuilder[] r = new StringBuilder[grid.length];
        StringBuilder[] c = new StringBuilder[grid[0].length];
        Map<String, Integer> rMap = new HashMap<>();
        Map<String, Integer> cMap = new HashMap<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(r[i] == null)
                    r[i] = new StringBuilder();
                r[i].append(grid[i][j] + ",");
                if(c[j] == null)
                    c[j] = new StringBuilder();
                c[j].append(grid[i][j] + ",");
            }
        }
        for(StringBuilder n : r)
            rMap.put(n.toString(), rMap.getOrDefault(n.toString(), 0) + 1);
        for(StringBuilder n : c)
            cMap.put(n.toString(), cMap.getOrDefault(n.toString(), 0) + 1);
        int res = 0;
        for(Map.Entry<String, Integer> e : rMap.entrySet()){
            if(cMap.containsKey(e.getKey())){
                res += e.getValue()  *cMap.get(e.getKey());
            }
        }
        return res;
    }
}