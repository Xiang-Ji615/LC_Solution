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
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        TreeSet<Integer> set = new TreeSet<>();
        dfs(root, set);
        List<List<Integer>> res = new ArrayList<>();
        for(int q : queries) {
            List<Integer> lst = Arrays.asList(set.floor(q) == null ? -1 : set.floor(q), set.ceiling(q) == null ? -1 : set.ceiling(q));
            res.add(lst);
        }
        return res;
    }
    
    void dfs(TreeNode node, TreeSet<Integer> set) {
        if(node == null)
            return;
        dfs(node.left, set);
        set.add(node.val);
        dfs(node.right, set);
    }
}