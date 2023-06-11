class Solution {
    public boolean isFascinating(int n) {
        String s = n + "" + n * 2 + "" + n * 3;
        boolean[] arr = new boolean[10];
        Arrays.fill(arr, true);
        for(char c : s.toCharArray()){
            if(!arr[c - '0'])
                return false;
            arr[c - '0'] = false;
        }
        for(int i=1;i<arr.length;i++) {
            if(arr[i])
                return false;
        }
        return true;
    }
}