class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        List<Integer> lst = new ArrayList<>();
        for(int n : nums)
            lst.add(n);
        Collections.sort(lst, (a, b) -> {
            int fa = 0, f = 1;
            if(a > 0){
                while(a > 0){
                    fa += mapping[a % 10] * f;
                    f *= 10;
                    a /= 10;
                }
            }else{
                fa = mapping[0];
            }
            int fb = 0;
            f = 1;
            if(b > 0){
                while(b > 0){
                    fb += mapping[b%10] * f;
                    f*=10;
                    b/=10;
                }
            }else{
                fb = mapping[0];
            }
            return fa - fb;
        });
        int[] res = new int[nums.length];
        for(int i=0;i<lst.size();i++){
            res[i] = lst.get(i);
        }
        return res;
    }
}