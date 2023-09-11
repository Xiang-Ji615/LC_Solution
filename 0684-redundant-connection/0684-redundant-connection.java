class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        UF uf = new UF();
        for(int[] e : edges) {
            if(uf.union(e[0], e[1]))
                return e;
        }
        return null;
    }
    
    class UF {
        int[] nums = new int[1001];
        
        public UF() {
            for(int i=0;i<nums.length;i++) {
                nums[i] = i;
            }
        }
        
        int find(int n) {
            if(nums[n] == n) {
                return n;
            }
            return nums[n] = find(nums[n]);
        }
        
        boolean union(int a, int b) {
            int pa = find(a), pb = find(b);
            if(pa == pb)
                return true;
            else
                nums[pa] = pb;
            return false;
        }
    }
}