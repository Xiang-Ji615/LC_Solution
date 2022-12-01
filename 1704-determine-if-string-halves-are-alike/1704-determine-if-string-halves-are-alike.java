class Solution {
    public boolean halvesAreAlike(String s) {
        Map<Character, Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
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