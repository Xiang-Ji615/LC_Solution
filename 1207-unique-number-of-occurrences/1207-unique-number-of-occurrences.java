class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int[] cnt = new int[2001];
        for(int n : arr) {
            cnt[n+1000]++;
        }
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<cnt.length;i++) {
            if(cnt[i] > 0 && !set.add(cnt[i]))
                return false;
        }
        return true;
    }
}