class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b) -> a[0] - b[0]);
        int max = 0;
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        for(int[] t : items){
            max = Math.max(t[1], max);
            tm.put(t[0], max);
        }
        int[] res = new int[queries.length];
        int cur = 0;
        for(int q : queries){
            Integer k = tm.floorKey(q);
            res[cur++] = (k == null) ? 0 : tm.get(k);
        }
        return res;
    }
}