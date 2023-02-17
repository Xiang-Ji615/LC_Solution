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
    int pre = -1;
    
    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return res;
    }
    
    void dfs(TreeNode node) {
        if(node == null)
            return;
        dfs(node.left);
        if(pre != -1) {
            res = Math.min(res, node.val - pre);
        }
        pre = node.val;
        dfs(node.right);
    }
}