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
    public int longestZigZag(TreeNode root) {
        if(root == null)
            return 0;
        return dfs(root)[2];
    }
    
    int[] dfs(TreeNode node){
        if(node == null)
            return new int[]{-1, -1, -1};
        int[] l = dfs(node.left);
        int[] r = dfs(node.right);
        int res = Math.max(Math.max(l[1], r[0]) + 1, Math.max(l[2], r[2]));
        return new int[]{l[1] + 1, r[0] + 1, res};
    }
}