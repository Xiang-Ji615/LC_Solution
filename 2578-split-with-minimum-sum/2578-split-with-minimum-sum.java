class Solution {
    public int splitNum(int num) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        while(num > 0) {
            minHeap.offer(num%10);
            num/=10;
        }
        int a = 0, b = 0;
        while(!minHeap.isEmpty()) {
            a*=10;
            a += minHeap.poll();
            if(!minHeap.isEmpty()) {
                b*=10;
                b += minHeap.poll();
            }
        }
        return a + b;
    }
}