class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, (a,b)->a[0]-b[0]);

        Long[][][] dp = new Long[robot.size()+1][factory.length+1][101];

        return helper(robot, factory, dp, 0, 0, 0);
    }

    public long helper(List<Integer> robot, int[][] factory, Long[][][] dp, int i, int j, int k) {
        if(i==robot.size()) return 0;
        if(j==factory.length) return Long.MAX_VALUE;
        if(dp[i][j][k] != null) return dp[i][j][k];

        long res1 = helper(robot, factory, dp, i, j+1, 0);
        long res2 = Long.MAX_VALUE;

        if(factory[j][1] > k) {
            long val = helper(robot, factory, dp, i+1, j, k+1);
            if(val != Long.MAX_VALUE) {
                res2 = Math.abs(robot.get(i)-factory[j][0]) + val;
            }
        }

        return dp[i][j][k] = Math.min(res1, res2);
    }
}