class Solution {
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int l = 0, r = Integer.MAX_VALUE;
        while(l < r) {
            int m = l + (r - l)/2;
            if(isValid(m, price, k)) {
                l = m + 1;
            }else{
                r = m;
            }
        }
        return l - 1;
    }
    
    boolean isValid(int m, int[] price, int k) {
        int last = price[0], cnt = 1, i = 1;
        while(cnt < k && i < price.length) {
            if(price[i] - last >= m) {
                last = price[i];
                cnt++;
            }
            i++;
        }
        return cnt == k;
    }
}