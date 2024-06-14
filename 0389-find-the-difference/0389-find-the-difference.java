class Solution {
    public char findTheDifference(String s, String t) {
        int diff = t.charAt(t.length() - 1) - 'a';
        for(int i=0;i<s.length();i++) {
            diff -= s.charAt(i);
            diff += t.charAt(i);
        }
        return (char)(diff + 'a');
    }
}