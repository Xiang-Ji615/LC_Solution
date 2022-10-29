class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int l = growTime.length;
        List<Integer> lst = new ArrayList<>();
        for(int i=0;i<l;i++) {
            lst.add(i);
        }
        Collections.sort(lst, (a, b) -> growTime[b] - growTime[a]);
        int res = 0;
        for(int i=0, plantSum = 0;i<l;i++) {
            int idx = lst.get(i);
            int time = plantSum + plantTime[idx] + growTime[idx];
            res = Math.max(res, time);
            plantSum += plantTime[idx];
        }
        return res;
    }
}