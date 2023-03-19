class Solution {
    public long findScore(int[] nums) {
        int l = nums.length;
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
           map.put(i, nums[i]);
        }
        Queue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getValue().equals(b.getValue()) ? a.getKey() - b.getKey() : a.getValue() - b.getValue());
        minHeap.addAll(map.entrySet());
        long res = 0;
        boolean[] visited = new boolean[l];
        while(!minHeap.isEmpty()) {
            Map.Entry<Integer, Integer> cur = minHeap.poll();
            int v = cur.getValue();
            int p = cur.getKey();
            if(!visited[p]) {
                res += v;
                visited[p] = true;
                if(p - 1 >= 0)
                    visited[p-1] = true;
                if(p + 1 < l)
                    visited[p+1] = true;
            }
        }
        return res;
    }
}
    
    
//     class Pair{
//     int num;
//     int index;
//     Pair(int num, int index)
//     { this.num = num; this.index = index; }
// }
// class Solution {
//     public long findScore(int[] nums) 
//     {
//         int n = nums.length;
//         PriorityQueue<Pair>pq = new PriorityQueue<Pair>((Pair a, Pair b)->{
//             if (a.num != b.num) return (a.num - b.num);
//             else return (a.index - b.index);
//         });
//         for (int i = 0; i < nums.length; i++ ) pq.add(new Pair(nums[i], i));
//         boolean[] marked = new boolean[n];
//         long ans = 0;
//         while(!pq.isEmpty())
//         {
//             int currNum = pq.peek().num;
//             int currIdx = pq.peek().index;
//             pq.poll();
//             if (marked[currIdx]) continue;
            
//             ans += currNum;
//             marked[currIdx] = true;
//             if (currIdx + 1 < n) marked[currIdx + 1] = true;
//             if (currIdx - 1 >= 0) marked[currIdx - 1] = true; 
//         }
//         return ans;
//     }
// }