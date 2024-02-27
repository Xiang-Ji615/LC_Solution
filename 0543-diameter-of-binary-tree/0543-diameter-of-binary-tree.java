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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        int cur = dfs(root.left) + dfs(root.right);
        int l = diameterOfBinaryTree(root.left);
        int r = diameterOfBinaryTree(root.right);
        return Math.max(cur, Math.max(l, r));
    }
    
    int dfs(TreeNode node){
        if(node == null)
            return 0;
        return 1 + Math.max(dfs(node.left), dfs(node.right));
    }
}