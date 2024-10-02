class Solution {
    public int[] arrayRankTransform(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new TreeSet<>();
        for(int n : arr)
            set.add(n);
        int cnt = 0;
        for(int n : set) {
            map.put(n, ++cnt);
        }
        for(int i=0;i<arr.length;i++) {
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
}