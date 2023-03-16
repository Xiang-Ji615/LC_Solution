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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i], i);
        }
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
    }
    
    TreeNode helper(int[] inorder, int is, int ie, int[] postorder, int ps, int pe, Map<Integer, Integer> map){
        if(is > ie || ps > pe){
            return null;
        }
        TreeNode res = new TreeNode(postorder[pe]);
        int idx = map.get(postorder[pe]);
        res.left = helper(inorder, is, idx-1, postorder, ps, ps + idx - is - 1, map);
        res.right = helper(inorder, idx+1, ie, postorder, ps + idx - is, pe-1, map);
        return res;
    }
}