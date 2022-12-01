class Solution {
    public boolean halvesAreAlike(String s) {
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int l = 0, r = s.length() - 1, a=0, b=0;
        while(l < r) {
            if(set.contains(s.charAt(l++)))
                a++;
            if(set.contains(s.charAt(r--)))
                b++;
        }
        return a == b;
    }
}