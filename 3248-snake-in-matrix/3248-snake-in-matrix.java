class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int res = 0;
        for(String c : commands) {
            if(c.equals("UP")) {
                res -= n;
            }else if(c.equals("DOWN")) {
                res += n;
            }else if(c.equals("LEFT")) {
                res--;
            }else{
                res++;
            }
        }
        return res;
    }
}