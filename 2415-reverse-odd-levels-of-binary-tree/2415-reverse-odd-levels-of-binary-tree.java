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
    public TreeNode reverseOddLevels(TreeNode root) {
        dfs(root, root, 0);
        return root;
    }
    
    void dfs(TreeNode n1, TreeNode n2, int l){
        if((n1.left == null && n2.right == null) || (n1.right == null && n2.left == null))
            return;
        if(l%2 == 0){
            int n = n1.left.val;
            n1.left.val = n2.right.val;
            n2.right.val = n;
        }
        dfs(n1.left, n2.right, l + 1);
        dfs(n1.right, n2.left, l + 1);
    }
}