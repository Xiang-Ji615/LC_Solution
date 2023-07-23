/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> res = new ArrayList<>();
        if(N%2 ==0) return res;
        if(N == 1){
            res.add(new TreeNode(0));
            return res;
        }
        for(int i=1;i<N-1;i+=2){
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(N-i-1);
            for(TreeNode l : left){
                for(TreeNode r : right){
                    TreeNode node = new TreeNode(0);
                    node.left = l;
                    node.right = r;
                    res.add(node);
                }
            }
        }
        return res;
    }
}