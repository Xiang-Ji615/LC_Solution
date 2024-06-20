class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int l = 1, r = 1000000000;
        while(l < r){
            int mi = (l + r + 1)/2;
            if(!isValid(position, m, mi)){
                r = mi-1;
            }else{
                l = mi;
            }
        }
        return l;
    }
    
    boolean isValid(int[] position, int m, int mi){
        int last = position[0];
        int remain = m - 1;
        for(int i=1;i<position.length && remain != 0;){
            if(position[i] - last < mi){
                i++;
            }else{
                last = position[i];
                remain--;
            }
        }
        return remain == 0;
    }
}