class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0, r = letters.length;
        while(l < r) {
            int m = l + (r - l)/2;
            if(letters[m] > target) {
                r = m;
            }else{
                l = m + 1;
            }
        }
        return l == letters.length ? letters[0] : letters[l];
    }
}