class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<numRows;i++) {
            if(i == 0) {
                res.add(Arrays.asList(1));
            }else{
                List<Integer> row = new ArrayList<>();
                row.add(1);
                List<Integer> prev = res.get(res.size() - 1);
                for(int j=1;j<prev.size();j++){
                    row.add(prev.get(j-1) + prev.get(j));
                }
                row.add(1);
                res.add(row);
            }
        }
        return res;
    }
}