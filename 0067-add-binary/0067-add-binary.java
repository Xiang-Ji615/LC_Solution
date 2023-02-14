class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int l1 = a.length() - 1, l2 = b.length() - 1, carry = 0;
        while(l1 >= 0 || l2 >= 0) {
            if(l1 >= 0) {
                carry += a.charAt(l1--) - '0';
            }
            if(l2 >= 0) {
                carry += b.charAt(l2--) - '0';
            }
            sb.insert(0, carry%2);
            carry/=2;
        }
        if(carry > 0) {
            sb.insert(0, carry);
        }
        return sb.toString();
    }
}