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
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null)
            return 0;
        return dfs(root.left, true) + dfs(root.right, false);
    }
    
    int dfs(TreeNode node, boolean isLeft) {
        if(node == null)
            return 0;
        if(node.left == null && node.right == null && isLeft)
            return node.val;
        return dfs(node.left, true) + dfs(node.right, false);
    }
}