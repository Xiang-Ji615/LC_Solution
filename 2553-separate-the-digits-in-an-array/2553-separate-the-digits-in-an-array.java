class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> lst = new ArrayList<>();
        for(int n : nums) {
            Stack<Integer> s = new Stack<>();
            while(n > 0) {
                s.push(n%10);
                n/=10;
            }
            while(!s.isEmpty()) {
                lst.add(s.pop());
            }
        }
        int[] res = new int[lst.size()];
        for(int i=0;i<lst.size();i++) {
            res[i] = lst.get(i);
        }
        return res;
    }
}