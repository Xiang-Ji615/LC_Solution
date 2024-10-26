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
    int[] preh = new int[100001], posth = new int[100001];
    int maxH;
    public int[] treeQueries(TreeNode root, int[] queries) {
        maxH = 0;
        preorder(root, 0);
        maxH = 0;
        postorder(root, 0);
        int[] res = new int[queries.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = Math.max(preh[queries[i]], posth[queries[i]]);
        }
        return res;
    }
    private void preorder(TreeNode root, int h) {
        if (root == null) return;
        preh[root.val] = maxH;
        maxH = Math.max(maxH, h);
        preorder(root.left, h + 1);
        preorder(root.right, h + 1);
    }
    private void postorder(TreeNode root, int h) {
        if (root == null) return;
        posth[root.val] = maxH;
        maxH = Math.max(maxH, h);
        postorder(root.right, h + 1);
        postorder(root.left, h + 1);
    }
}