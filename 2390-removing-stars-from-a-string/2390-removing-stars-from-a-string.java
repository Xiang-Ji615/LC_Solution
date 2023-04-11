class Solution {
    public String removeStars(String s) {
        Deque<Character> dq = new ArrayDeque<>();
        for(char c : s.toCharArray()) {
            if(c == '*') {
                dq.pollLast();
            }else{
                dq.offer(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!dq.isEmpty()) {
            sb.append(dq.poll());
        }
        return sb.toString();
    }
}