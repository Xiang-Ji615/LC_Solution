/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    int res = Integer.MAX_VALUE;
    
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        dfs(root, 1);
        return res;
    }
    
    void dfs(TreeNode node, int l) {
        if(node == null || l > res) return;
        if(node.left == null && node.right == null){
            res = Math.min(res, l);
            return;
        }
        dfs(node.left, l+1);
        dfs(node.right, l + 1);
    }
}