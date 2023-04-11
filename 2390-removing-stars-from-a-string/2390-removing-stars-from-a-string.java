class Solution {
    public String removeStars(String s) {
        Stack<Character> stk = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c == '*') {
                stk.pop();
            }else{
                stk.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stk.isEmpty()) {
            sb.insert(0, stk.pop());
        }
        return sb.toString();
    }
}