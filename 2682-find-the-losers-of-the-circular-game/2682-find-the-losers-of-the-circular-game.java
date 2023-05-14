class Solution {
    public int[] circularGameLosers(int n, int k) {
        boolean[] visited = new boolean[n];
        int cur = 0, t = 0;
        while(!visited[cur]) {
            visited[cur] = true;
            cur = (cur + ++t*k)%n;
        }
        List<Integer> lst = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!visited[i])
                lst.add(i+1);
        }
        int[] res = new int[lst.size()];
        for(int i=0;i<lst.size();i++) {
            res[i] = lst.get(i);
        }
        return res;
    }
}