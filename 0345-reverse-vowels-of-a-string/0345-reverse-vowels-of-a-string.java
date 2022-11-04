class Solution {
    public String reverseVowels(String s) {
        int l = 0, r = s.length() - 1;
        char[] cArr = s.toCharArray();
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
        while(l < r){
          if(set.contains(cArr[l]) && set.contains(cArr[r]) && cArr[l] != cArr[r]){
                char tmp = cArr[l];
                cArr[l] = cArr[r];
                cArr[r] = tmp;
                l++;
                r--;
            }else if(set.contains(cArr[l]) && !set.contains(cArr[r]))
                r--;
            else if(set.contains(cArr[r]) && !set.contains(cArr[l]))
                l++;
            else{
                l++;
                r--;
            }
        }
        return new String(cArr);
    }
}