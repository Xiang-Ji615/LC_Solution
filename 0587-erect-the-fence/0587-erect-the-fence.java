class Solution {
    public int[][] outerTrees(int[][] points) {
        // sort the point of P by x-coor (case tie, sort by y-coor)
        Arrays.sort(points, (p,q) -> q[0] == p[0]? q[1] - p[1] : q[0] - p[0]);
        
        // hold the vertices of upper and lower hulls 
        Stack<int[]> hull = new Stack<>();
        int n = points.length;
        
        // A. Build Lower layer of hulls
        for (int i = 0; i < n; i++) {
            // sequence of last two points of Lower hulls 
            // and the point P[i] does not make a counter-clockwise turn
            while (hull.size() >= 2  &&
             orientation(hull.get(hull.size()-2), hull.get(hull.size() - 1), points[i]) > 0) {
                hull.pop();             // remove q on (p,q,r)
            }
            hull.push(points[i]);
        }
        hull.pop();     
       
        // B. Build uper layer of hulls
        for (int i = n - 1; i >= 0; i--) {
            while (hull.size() >= 2 &&
             orientation(hull.get(hull.size() - 2), hull.get(hull.size() -1), points[i]) > 0) {
                hull.pop();
            } 
            hull.push(points[i]);
        }
        // Remove last point of list (it's same as first point of  other list).
        // remove redundant elements from the stack
        HashSet<int[]> set = new HashSet<>(hull);
        return set.toArray(new int[set.size()][]);
    }
    public int orientation(int[] p, int[] q, int[] r) {
        return (q[1] - p[1]) * (r[0] - q[0])  - (q[0] - p[0])*(r[1] - q[1]);
    }
}