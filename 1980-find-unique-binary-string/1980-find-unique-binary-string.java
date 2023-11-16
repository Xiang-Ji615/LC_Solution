class Solution {
    public String findDifferentBinaryString(String[] nums) {
        Set<String> set = new HashSet<>();
        for(String n : nums)
            set.add(n);
        for(int i=0;i<=Math.pow(nums.length, 2);i++){
            String s = convert(i, nums.length);
            if(!set.contains(s))
                return s;
        }
        return null;
    }
    
    String convert(int n, int l){
        StringBuilder sb = new StringBuilder();
        for(int i=l-1;i>=0;i--){
            sb.append((n&1<<i) == 0 ? "1" : "0");
        }
        return sb.toString();
    }
}