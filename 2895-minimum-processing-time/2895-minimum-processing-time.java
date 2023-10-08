class Solution {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        Collections.sort(processorTime);
        Collections.sort(tasks, (a, b) -> b - a);
        int cur = -1, res = 0;
        for(int i=0;i<tasks.size();i++) {
            if(i % 4 == 0) {
                cur++;
            }
            res = Math.max(res, processorTime.get(cur) + tasks.get(i));
        }
        return res;
    }
}