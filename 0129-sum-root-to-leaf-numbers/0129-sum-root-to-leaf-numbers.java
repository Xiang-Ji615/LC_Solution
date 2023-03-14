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
    
    int res = 0;
    
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return res;
    }
    
    void dfs(TreeNode node, int n) {
        if(node == null)
            return;
        if(node.left == null && node.right == null) {
            res += n*10 + node.val;
            return;
        }
        dfs(node.left, n * 10 + node.val);
        dfs(node.right, n * 10 + node.val);
    }
}