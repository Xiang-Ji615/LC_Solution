class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<T.length;i++){
            while(!s.isEmpty() && T[s.peek()] < T[i]){
                res[s.peek()] = i - s.pop();
            }
            s.push(i);
        }
        return res;
    }
}