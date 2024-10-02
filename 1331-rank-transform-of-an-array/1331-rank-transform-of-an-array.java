class Solution {
    public int[] arrayRankTransform(int[] arr) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        for(int i=0;i<arr.length;i++) {
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        int cnt = 1;
        for(Map.Entry<Integer, List<Integer>> e : map.entrySet()) {
            for(int p : e.getValue()) {
                arr[p] = cnt;
            }
            cnt++;
        }
        return arr;
    }
}