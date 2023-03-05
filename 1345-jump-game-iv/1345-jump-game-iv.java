class Solution {
    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[arr.length];
        visited[0] = true;
        q.offer(0);
        int res = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int cur = q.poll();
                if(cur == arr.length - 1)
                    return res;
                List<Integer> next = map.getOrDefault(arr[cur], new ArrayList<>());
                next.add(cur-1);
                next.add(cur+1);
                for(int j : next){
                    if(j >= 0 && j < arr.length && !visited[j]){
                        q.offer(j);
                        visited[j] = true;
                    }
                }
                next.clear();
            }
            res++;
        }
        return -1;
    }
}