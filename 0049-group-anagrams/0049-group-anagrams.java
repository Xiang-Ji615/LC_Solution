class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String k = new String(arr);
            map.putIfAbsent(k, new ArrayList<>());
            map.get(k).add(s);
        }
        for(List<String> v : map.values()) {
            res.add(new ArrayList<>(v));
        }
        return res;
    }
}