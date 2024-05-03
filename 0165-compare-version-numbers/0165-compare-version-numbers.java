class Solution {
    public int compareVersion(String version1, String version2) {
        int c1 = 0, c2 = 0;
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        if(arr1.length < arr2.length) {
            int res = compareVersion(version2, version1);
            return res == 0 ? 0 : -res;
        }
        while(c1 < arr1.length && c2 < arr2.length) {
            Long n1 = Long.parseLong(arr1[c1++]);
            Long n2 = Long.parseLong(arr2[c2++]);
            if(!n1.equals(n2)) {
                if(n1.compareTo(n2) > 0)
                    return 1;
                return -1;
            }
        }
        while(c1 < arr1.length) {
            if(Long.parseLong(arr1[c1++]) > 0)
                return 1;
        }
        return 0;
    }
}