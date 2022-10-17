class Solution {
    public boolean checkIfPangram(String sentence) {
        int cur = 0, target = 67108863;
        Set<Character> set = new HashSet<>();
        for(char c : sentence.toCharArray()) {
            cur |= (1 << c - 'a');
        }
        return cur == target;
    }
}