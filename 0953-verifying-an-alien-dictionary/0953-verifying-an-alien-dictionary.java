class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<order.length();i++){
            map.put(order.charAt(i), i);
        }
        for(int i=1;i<words.length;i++){
            if(!isValid(map, words[i-1], words[i])){
                return false;
            }
        }
        return true;
    }
    
    boolean isValid(Map<Character, Integer> map, String s1, String s2){
        for(int i=0;i<Math.min(s1.length(), s2.length());i++){
            if(map.get(s1.charAt(i)) < map.get(s2.charAt(i)))
                return true;
            if(map.get(s1.charAt(i)) > map.get(s2.charAt(i)))
                return false;
        }
        return s1.length() <= s2.length();
    }
}