class RandomizedSet {
    
    List<Integer> lst;
    Map<Integer, Integer> map;
    Random rand;

    public RandomizedSet() {
        lst = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val))
            return false;
        map.put(val, lst.size());
        lst.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val))
            return false;
        int p = map.get(val);
        if(p < lst.size()){
            int last = lst.get(lst.size() - 1);
            map.put(last, p);
            lst.set(p, last);
        }
        map.remove(val);
        lst.remove(lst.size() - 1);
        return true;
    }
    
    public int getRandom() {
        return lst.get(rand.nextInt(lst.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */