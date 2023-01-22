class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        int[][] res = new int[score.length][score[0].length];
        Queue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[k] - a[k]);
        for(int[] s : score)
            maxHeap.offer(s);
        int r = 0;
        while(!maxHeap.isEmpty()) {
            res[r++] = maxHeap.poll();
        }
        return res;
    }
}