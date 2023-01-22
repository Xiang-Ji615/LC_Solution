class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if(s == null || s.length() == 0)
            return res;
        dfs(s, res, new ArrayList<>(), 0);
        return res;
    }
    
    void dfs(String s, List<List<String>> res, List<String> lst, int cur) {
        if(cur == s.length()) {
            res.add(new ArrayList<>(lst));
            return;
        }
        for(int i=cur;i<s.length();i++) {
            if(isPal(s.substring(cur, i+1))) {
                lst.add(s.substring(cur, i+1));
                dfs(s, res, lst, i+1);
                lst.remove(lst.size() - 1);
            }
        }
    }
    
    boolean isPal(String s) {
        int l = 0, r = s.length() - 1;
        while(l < r) {
            if(s.charAt(l++) != s.charAt(r--))
                return false;
        }
        return true;
    }
}