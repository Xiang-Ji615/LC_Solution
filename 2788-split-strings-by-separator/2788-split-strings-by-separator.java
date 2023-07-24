class Solution {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> res = new ArrayList<>();
        for(String w : words) {
            String[] arr = w.split("\\" + separator);
            for(String s : arr){
                if(s.length() > 0)
                    res.add(s);
            }
        }
        return res;
    }
}