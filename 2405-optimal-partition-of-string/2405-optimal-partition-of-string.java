class Solution {
    public int partitionString(String s) {
        int res = 0;
        boolean[] visited = new boolean[26];
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(visited[c - 'a']) {
                visited = new boolean[26];
                res++;
            }
            visited[c - 'a'] = true;
        }
        for(boolean v : visited){
            if(v)
                return ++res;
        }
        return res;                    
    }
}