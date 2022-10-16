class Solution {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums) {
            set.add(n);
            set.add(rev(n));
        }
        return set.size();
    }
    
    int rev(int n) {
        int res = 0;
        while(n > 0) {
            res = res * 10 + n%10;
            n/=10;
        }
        return res;
    }
}