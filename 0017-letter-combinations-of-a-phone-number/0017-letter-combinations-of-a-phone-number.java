class Solution {
    
    String[] arr = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0)
            return res;
        dfs(res, digits, 0, new StringBuilder());
        return res;
    }
    
    void dfs(List<String> res, String digits, int cur, StringBuilder sb) {
        if(sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }
        for(char c : arr[digits.charAt(cur) - '0'].toCharArray()) {
            sb.append(c);
            dfs(res, digits, cur+1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}