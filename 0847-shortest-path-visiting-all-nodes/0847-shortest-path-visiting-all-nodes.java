class Solution {
    public int shortestPathLength(int[][] graph) {
        int l = graph.length;
        Queue<Node> q = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        for(int i=0;i<l;i++){
            int mask = (1 << i);
            visited.add(new Node(mask, i, 0));
            q.offer(new Node(mask, i, 1));
        }
        while(!q.isEmpty()){
            Node cur = q.poll();
            if(cur.mask == (1 << l) - 1)
                return cur.weight - 1;
            else{
                for(int nei : graph[cur.cur]){
                    int mask = cur.mask;
                    mask = mask | (1 << nei);
                    Node next = new Node(mask, nei, 0);
                    if(!visited.contains(next)){
                        visited.add(next);
                        q.offer(new Node(mask, nei, cur.weight + 1));
                    }
                }
            }
        }
        return -1;
    }
    
    class Node{
        int mask;
        int cur;
        int weight;
        
        public Node(int mask, int cur, int weight){
            this.mask = mask;
            this.cur = cur;
            this.weight = weight;
        }
        
        @Override
        public boolean equals(Object o){
            Node n = (Node)o;
            return this.mask == n.mask && this.cur == n.cur && this.weight == n.weight; 
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(mask, cur, weight);
        }
    }
}