class Solution {
    
    Set<Character> set = new HashSet<>();
    
    public String sortVowels(String s) {
        set.addAll(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        Queue<Character> minHeap = new PriorityQueue<>((a, b) -> a - b);
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {
            if(set.contains(c))
                minHeap.add(c);
        }
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(set.contains(c)) {
                sb.append(minHeap.poll());
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}