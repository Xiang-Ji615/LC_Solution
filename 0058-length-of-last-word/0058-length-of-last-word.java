class Solution {
    public int lengthOfLastWord(String s) {
        String[] arr = s.split("\\W+");
        return arr[arr.length - 1].length();
    }
}