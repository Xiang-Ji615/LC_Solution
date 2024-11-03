class Solution {
    public boolean rotateString(String A, String B) {
        String sumA = A+A;
        return A.length() == B.length() &&  sumA.contains(B);
    }
}