class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : arr)
            map.put(n, map.getOrDefault(n, 0) + 1);
        Queue<Integer> minHeap = new PriorityQueue<>();
        minHeap.addAll(map.values());
        while(!minHeap.isEmpty() && k >= minHeap.peek()) {
            k -= minHeap.poll();
        }
        return minHeap.size();
    }
}