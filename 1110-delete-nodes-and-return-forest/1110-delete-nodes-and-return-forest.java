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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> res = new ArrayList<>();
        if(root == null)
            return res;
        Set<Integer> set = new HashSet<>();
        for(int t : to_delete){
            set.add(t);
        }
        if(!set.contains(root.val))
            res.add(root);
        dfs(root, res, set);
        return res;
    }
    
    TreeNode dfs(TreeNode node, List<TreeNode> res, Set<Integer> set){
        if(node == null)
            return null;
        node.left = dfs(node.left, res, set);
        node.right = dfs(node.right, res, set);
        if(set.contains(node.val)){
            if(node.left != null)
                res.add(node.left);
            if(node.right != null)
                res.add(node.right);
            return null;
        }
        return node;
    }
}