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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        if(root == null)
            return res;
        dfs(root, res, new HashMap<>());
        return res;
    }
    
    String dfs(TreeNode node, List<TreeNode> res, Map<String, Integer> map){
        if(node == null)
            return "#";
        String serial = node.val + "," + dfs(node.left, res, map) + "," + dfs(node.right, res, map);
         if(map.getOrDefault(serial, 0) == 1){
            res.add(node);
        }
        map.put(serial, map.getOrDefault(serial, 0) + 1);
        return serial;
    }
}