class Solution {
    public int bestClosingTime(String customers) {
        int[] arr1 = new int[customers.length() + 1], arr2 = new int[customers.length() + 1];
        int sum1 = 0, sum2 = 0;
        for(int i=0;i<customers.length();i++) {
            if(customers.charAt(i) == 'Y') {
                sum1++;
            }else{
                sum2++;
            }
            arr1[i+1] = sum1;
            arr2[i+1] = sum2;
        }
        int res = arr1[arr1.length-1];
        Map<Integer, Integer> map = new HashMap<>();
        map.putIfAbsent(res, 0);
        for(int i=0;i<customers.length();i++) {
            int p = arr2[i+1] + (arr1[arr1.length-1] - arr1[i+1]);
            res = Math.min(res, p);
            map.putIfAbsent(res, i+1);
        }
        return map.get(res);
    }
}