class Solution {
    class MinMax{
        int min, max;
        public MinMax(int min, int max){
            this.min = min;
            this.max = max;
        }
    }
    
    public boolean find132pattern(int[] nums) {
        Stack<MinMax> stack = new Stack<>();
        for(int i=0;i<nums.length;i++){
            int n = nums[i];
            if(stack.isEmpty() || stack.peek().min > nums[i]){
                stack.push(new MinMax(n, n));
            }else if(!stack.isEmpty() && stack.peek().min < n){
                MinMax mm = stack.pop();
                if(mm.max > n)
                    return true;
                else{
                    mm.max = Math.max(mm.max, n);
                    while(!stack.isEmpty() && stack.peek().max <= n){
                        stack.pop();
                    }
                    if(!stack.isEmpty() && stack.peek().min < n)
                        return true;
                    stack.push(mm);
                }
            }
        }
        return false;
    }
}