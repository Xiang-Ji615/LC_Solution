class LRUCache {
    
    class Node{
        Node prev, next;
        int k, v;
        public Node(int k, int v){
            this.k = k;
            this.v = v;
        }
    }
    
    Node head, tail;
    int cnt = 0, capacity = 0;
    Map<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        head.prev = null;
        tail.next = null;
        tail.prev = head;
    }
    
    public void add(Node node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
    
    public void delete(Node node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
    
    public void moveToHead(Node node){
        delete(node);
        add(node);
    }
    
    public Node removeLast(){
        Node res = tail.prev;
        delete(res);
        return res;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            moveToHead(map.get(key));
            return map.get(key).v;
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(!map.containsKey(key)){
            Node node = new Node(key, value);
            map.put(key, node);
            add(node);
            cnt++;
            if(cnt > capacity){
                Node n = removeLast();
                map.remove(n.k);
                cnt--;
            }
        }else{
            map.get(key).v = value;
            moveToHead(map.get(key));
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */