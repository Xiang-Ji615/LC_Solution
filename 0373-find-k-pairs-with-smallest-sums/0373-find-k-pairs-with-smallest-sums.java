class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        Queue<int[]> minHeap = new PriorityQueue<>((a, b)->a[0] + a[1] - b[0] - b[1]);
        List<List<Integer>> res = new ArrayList<>();
        if(nums1.length == 0 || nums2.length == 0 || k == 0)
            return res;
        for(int i=0;i<nums1.length && i < k;i++) {
            minHeap.offer(new int[]{nums1[i], nums2[0], 0});
        }
        while(k-- > 0 && !minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            res.add(Arrays.asList(cur[0], cur[1]));
            if(cur[2] == nums2.length - 1)
                continue;
            minHeap.offer(new int[]{cur[0], nums2[cur[2] + 1], cur[2] + 1});
        }
        return res;
    }
}