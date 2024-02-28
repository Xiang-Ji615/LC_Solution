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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode res = null;
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            res = node;
            if(node.right != null)
                q.offer(node.right);
            if(node.left != null)
                q.offer(node.left);
        }
        return res.val;
    }
}