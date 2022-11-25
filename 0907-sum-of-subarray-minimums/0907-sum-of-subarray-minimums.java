class Solution {
    public int sumSubarrayMins(int[] arr) {
        int mod = (int)1e9 + 7, res = 0;
        Stack<Integer> s = new Stack<>();
        int[] dp = new int[arr.length + 1];
        s.push(-1);
        for(int i=0;i<arr.length;i++) {
            while(s.peek() != -1 && arr[s.peek()] > arr[i]) {
                s.pop();
            }
            dp[i+1] = (dp[s.peek() + 1] + (i - s.peek())*arr[i]) % mod;
            s.push(i);
            res = (res + dp[i+1]) % mod;
        }
        return res;
    }
}