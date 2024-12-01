class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int cnt = 0;
        for(int n : arr){
            set.add(n);
            if(n == 0)
                cnt++;
        }
        for(int n : arr){
            if(n != 0 && set.contains(n*2))
                return true;
            if(n == 0 && cnt > 1)
                return true;
        }
        return false;
    }
}