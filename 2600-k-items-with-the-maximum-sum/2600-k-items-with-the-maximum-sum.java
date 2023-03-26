class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for(int i=0;i<numOnes;i++)
            maxHeap.offer(1);
        for(int i=0;i<numZeros;i++)
            maxHeap.offer(0);
        for(int i=0;i<numNegOnes;i++)
            maxHeap.offer(-1);
        int res = 0;
        while(!maxHeap.isEmpty() && k-- > 0)
            res += maxHeap.poll();
        return res;
    }
}