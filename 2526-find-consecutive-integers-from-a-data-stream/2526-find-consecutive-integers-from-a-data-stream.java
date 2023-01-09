class DataStream {
    
    int k = 0, v = 0;
    Map<Integer, Integer> map = new HashMap<>();

    public DataStream(int value, int k) {
        map.put(value, k);
        this.k = k;
        this.v = value;
    }
    
    public boolean consec(int num) {
        if(num == v) {
            map.put(num, map.get(num) - 1);
            if(map.get(num) <= 0)
                return true;
            return false;
        }else {
            map.put(v, k);
            return false;
        }
    }
}

/**
 * Your DataStream object will be instantiated and called as such:
 * DataStream obj = new DataStream(value, k);
 * boolean param_1 = obj.consec(num);
 */