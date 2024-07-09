class Solution {
    public double averageWaitingTime(int[][] customers) {
        double[] nums = new double[customers.length];
        int tmp = customers[0][0];
        for(int i=0;i<customers.length;i++){
            nums[i] = Math.max(tmp, customers[i][0]) - customers[i][0] + customers[i][1];
            tmp += customers[i][1];
            tmp = Math.max(tmp, customers[i][0] + customers[i][1]);
        }
        double res = 0;
        for(double n : nums)
            res += n;
        return res/nums.length;
    }
}