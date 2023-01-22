class Solution {
    public int alternateDigitSum(int n) {
        int res = 0, f = 0;
        Stack<Integer> stk = new Stack();
        while(n > 0) {
            stk.push(n % 10);
            n/=10;
        }
        while(!stk.isEmpty()) {
            int cur = stk.pop();
            if((f ^= 1) == 1) {
                res += cur;
            }else{
                res -= cur;
            }
        }
        return res;
    }
}