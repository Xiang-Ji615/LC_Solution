class Solution {
    public int subarraysDivByK(int[] A, int K) {
        // int[] preSum = new int[A.length+1];
        // for(int i=1;i<=A.length;i++){
        //     preSum[i] = preSum[i-1] + A[i-1];
        // }
        // // System.out.println(Arrays.toString(preSum));
        // int res = 0;
        // for(int i=0;i<=A.length;i++){
        //     for(int j=i+1;j<=A.length;j++){
        //         int sum = preSum[j] - preSum[i];
        //         // System.out.println(i + ":" + j);
        //         if(sum%K == 0){
        //             // System.out.println("Sum : " + sum + ", " + i + ":" + j);
        //             res++;
        //         }
        //     }
        // }
        // return res;
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int cnt = 0, sum = 0;
        for(int a : A){
            sum = (sum + a)%K;
            if(sum < 0)
                sum += K;
            cnt += map.getOrDefault(sum, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return cnt;
    }
}