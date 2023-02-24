class Solution {
    public int minimumDeviation(int[] nums) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        int l = nums.length, mi = Integer.MAX_VALUE, res = Integer.MAX_VALUE;
        for(int n : nums){
            if(n % 2 == 1){
                n *= 2;
            }
            minHeap.offer(-n);
            mi = Math.min(mi, n);
        }
        while(true){
            int a = -minHeap.poll();
            res = Math.min(res, a - mi);
            if(a%2 == 1)
                break;
            mi = Math.min(mi, a/2);
            minHeap.offer(-a/2);
        }
        return res;
    }
}