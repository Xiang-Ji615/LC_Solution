class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for(int c : candies) {
            max = Math.max(max, c);
        }
        for(int i=0;i<candies.length;i++) {
            res.add(candies[i] + extraCandies >= max);
        }
        return res;
    }
}