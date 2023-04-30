class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        // System.out.println((long)1 << 33);
        long m1 = 0, m2 = 0;
        int[] res = new int[A.length];
        for(int i=0;i<A.length;i++) {
            m1 |= ((long)1 << A[i]);
            m2 |= ((long)1 << B[i]);
            // System.out.println(i + ": " + m1 + ", " + m2);
            res[i] = common(m1, m2);
        }
        return res;
    }
    
    int common(long m1, long m2) {
        int res = 0;
        long l = m1 & m2;
        while(l != 0) {
            if(l%2 == 1)
                res++;
            l/=2;
        }
        return res;
    }
}