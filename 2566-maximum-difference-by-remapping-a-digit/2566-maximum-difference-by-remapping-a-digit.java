class Solution {
    public int minMaxDifference(int num) {
        String s = Integer.toString(num);
        char maxC = '9';
        for(char c : s.toCharArray()) {
            if(c != '9') {
                maxC = c;
                break;
            }
        }
        String maxStr = s.replace(maxC, '9');
        String minStr = s.replace(s.charAt(0), '0');
        return Integer.parseInt(maxStr) - Integer.parseInt(minStr);
    }
}