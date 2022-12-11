class Solution {
    public boolean isCircularSentence(String strs) {
        String[] arr = strs.split("\\W+");
        for(int i=1;i<arr.length;i++) {
            if(arr[i-1].charAt(arr[i-1].length() - 1) != arr[i].charAt(0)){
                return false;
            }
        }
        return arr[0].charAt(0) == arr[arr.length - 1].charAt(arr[arr.length - 1].length() - 1);
    }
}