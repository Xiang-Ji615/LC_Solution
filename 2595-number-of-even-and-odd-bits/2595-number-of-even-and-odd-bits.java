class Solution {
    public int[] evenOddBit(int n) {
        int[] arr = new int[10];
        Arrays.fill(arr, -1);
        int cur = 9;
        int[] res = new int[2];
        while(n > 0) {
            arr[cur] = n % 2 == 1 ? 1 : 0;
            if(cur % 2 == 1&& arr[cur] == 1)
                res[0]++;
            else if(cur % 2 == 0 && arr[cur] == 1)
                res[1]++;
            cur--;
            n/=2;
        }
        return res;
    }
}