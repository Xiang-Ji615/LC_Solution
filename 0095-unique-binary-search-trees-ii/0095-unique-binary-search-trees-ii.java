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
    public List<TreeNode> generateTrees(int n) {
        if(n == 0)
            return new ArrayList<>();
        return dfs(1, n);
    }
    
    List<TreeNode> dfs(int l, int r){
        List<TreeNode> res = new ArrayList<>();
        if(l > r){
            res.add(null);
            return res;
        }
        
        for(int i=l;i<=r;i++){
            List<TreeNode> left = dfs(l, i-1);
            List<TreeNode> right = dfs(i+1, r);
            
            for(TreeNode lNode : left){
                for(TreeNode rNode : right){
                    TreeNode root = new TreeNode(i);
                    root.left = lNode;
                    root.right = rNode;
                    res.add(root);
                }
            }
        }
        
        return res;
    }
}