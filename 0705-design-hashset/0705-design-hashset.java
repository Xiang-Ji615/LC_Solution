class MyHashSet {
    
    int buckets = 1000;
    int itemsPerBucket = 1001;
    boolean[][] table;

    /** Initialize your data structure here. */
    public MyHashSet() {
        table = new boolean[buckets][];
    }
    
    int hash(int key){
        return key % buckets;
    }
    
    int pos(int key){
        return key / buckets;
    }
    
    public void add(int key) {
        int hashKey = hash(key);
        if(table[hashKey] == null)
            table[hashKey] = new boolean[itemsPerBucket];
        table[hashKey][pos(key)] = true;
    }
    
    public void remove(int key) {
        int hashKey = hash(key);
        if(table[hashKey] != null)
            table[hashKey][pos(key)] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hashKey = hash(key);
        return table[hashKey] != null && table[hashKey][pos(key)] == true;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */