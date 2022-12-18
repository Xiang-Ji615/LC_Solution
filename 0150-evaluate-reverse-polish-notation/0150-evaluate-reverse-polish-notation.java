class Solution {
    public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();
		int a,b;
		for(String s : tokens) {
			if(s.equals("+")) {
				b = stack.pop();
				a = stack.pop();
				stack.push(a+b);
			}
			else if(s.equals("-")){
				b = stack.pop();
				a = stack.pop();
				stack.push(a-b);
			}
			else if(s.equals("*")) {
				b = stack.pop();
				a = stack.pop();
				stack.push(a * b);
			}
			else if(s.equals("/")) {
				b = stack.pop();
				a = stack.pop();
				stack.push(a / b);
			}
			else {
				stack.push(Integer.valueOf(s));
			}
		}
		return stack.pop();
    }
}