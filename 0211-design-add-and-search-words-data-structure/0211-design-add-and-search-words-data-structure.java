class WordDictionary {
    
    Node root;

    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node ref = root;
        for(char c : word.toCharArray()){
            if(ref.next[c - 'a'] == null) {
                ref.next[c - 'a'] = new Node();
            }
            ref = ref.next[c - 'a'];
        }
        ref.isWord = true;
        ref.s = word;
    }
    
    public boolean search(String word) {
        Node ref = root;
        return dfs(word, ref, 0);
    }
    
    boolean dfs(String s, Node ref, int cur){
        if(ref == null)
            return false;
        if(cur == s.length()){
            if(ref.isWord)
                return true;
            return false;
        }
        char c = s.charAt(cur);
        boolean res = false;
        if(c == '.') {
            for(Node nei : ref.next){
                if(dfs(s, nei, cur+1))
                    return res |= true;
            }
        }else {
            if(dfs(s, ref.next[c - 'a'], cur + 1))
                return res |= true;
        }
        return res;
    }
}

class Node {
    Node[] next;
    boolean isWord;
    String s;
    public Node(){
        this.next = new Node[26];
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */