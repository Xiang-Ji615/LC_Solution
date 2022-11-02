class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Queue<String> q = new LinkedList<>();
        q.offer(start);
        int res = 0;
        Set<String> visited = new HashSet<>();
        Set<String> set = new HashSet<>();
        for(String b : bank)
            set.add(b);
        visited.add(start);
        char[] arr = {'A', 'C', 'G', 'T'};
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                String cur = q.poll();
                if(cur.equals(end))
                    return res;
                char[] cArr = cur.toCharArray();
                for(int j=0;j<cArr.length;j++){
                    char old = cArr[j];
                    for(char c : arr){
                        cArr[j] = c;
                        String next = new String(cArr);
                        if(set.contains(next) && !visited.contains(next)){
                            q.offer(next);
                            visited.add(next);
                        }
                    }
                    cArr[j] = old;
                }
            }
            res++;
        }
        return -1;
    }
}