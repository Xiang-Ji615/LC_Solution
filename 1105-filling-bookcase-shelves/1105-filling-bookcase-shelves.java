class Solution {
    public int minHeightShelves(int[][] books, int shelf_width) {
        int[] dp = new int[books.length + 1];
        for(int i=1;i<=books.length;i++){
            int[] cur = books[i-1];
            int w = cur[0], h = cur[1];
            dp[i] = dp[i-1] + h;
            for(int j=i-1;j>0 && w + books[j-1][0] <= shelf_width;j--){
                h = Math.max(h, books[j-1][1]);
                w += books[j-1][0];
                dp[i] = Math.min(dp[i], dp[j-1] + h);
            }
        }
        return dp[books.length];
    }
}