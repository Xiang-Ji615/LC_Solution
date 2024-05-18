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
    int res = 0;
    public int distributeCoins(TreeNode root) {
        if(root == null)
            return 0;
        dfs(root);
        return res;
    }
    
    int dfs(TreeNode node){
        if(node == null)
            return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        res += Math.abs(left) + Math.abs(right);
        return left + right + node.val - 1;
    }
}