class Solution {
    public int minLength(String s) {
        Stack<Character> stk = new Stack<>();
        for(char c : s.toCharArray()) {
            if(!stk.isEmpty()) {
                String p = "" + stk.peek() + c;
                // System.out.println(p);
                if(p.equals("AB") || p.equals("CD")) {
                    stk.pop();
                    continue;
                }else {
                    stk.push(c);
                }
            }else {
                stk.push(c);
            }
        }
        return stk.size();
    }
}