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
    public int maxProduct(TreeNode root) {
        List<Long> lst = new ArrayList<>();
        int mod = (int)1e9 + 7;
        long t = dfs(root, lst);
        long res = 0;
        for(long n : lst) {
            res = Math.max(res, n * (t - n));
        }
        return (int)(res % mod);
    }
    
    long dfs(TreeNode node, List<Long> lst) {
        if(node == null)
            return 0;
        long l = dfs(node.left, lst);
        long r = dfs(node.right, lst);
        lst.add(node.val + l + r);
        return node.val + l + r;
    }
}