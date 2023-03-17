class Trie {
    
    class Node {
        
        boolean isStr;
        Node[] next;
        
        public Node() {
            next = new Node[26];
        }
    }
    
    Node root = new Node();

    public Trie() {
    }
    
    public void insert(String word) {
        Node node = root;
        for(char c : word.toCharArray()) {
            if(node.next[c - 'a'] == null)
                node.next[c - 'a'] = new Node();
            node = node.next[c - 'a'];
        }
        node.isStr = true;
    }
    
    public boolean search(String word) {
        Node node = root;
        for(char c : word.toCharArray()) {
            if(node.next[c - 'a'] == null)
                return false;
            node = node.next[c - 'a'];
        }
        return node.isStr;
    }
    
    public boolean startsWith(String prefix) {
        Node node = root;
        for(char c : prefix.toCharArray()) {
            if(node.next[c - 'a'] == null)
                return false;
            node = node.next[c - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */