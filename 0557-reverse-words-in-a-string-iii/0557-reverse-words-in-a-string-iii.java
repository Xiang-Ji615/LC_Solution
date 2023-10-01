class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        for(String w : s.split(" ")) {
            int l = 0, r = w.length() - 1;
            char[] arr = w.toCharArray();
            while(l < r) {
                char c = arr[l];
                arr[l++] = arr[r];
                arr[r--] = c;
            }
            sb.append(String.valueOf(arr) + " ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}