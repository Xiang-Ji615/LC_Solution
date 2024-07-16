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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for(int[] d : descriptions){
            int p = d[0], c = d[1], isLeft = d[2];
            set.add(c);
            TreeNode node = map.getOrDefault(p, new TreeNode(p));
            if(isLeft == 1){
                node.left = map.getOrDefault(c, new TreeNode(c));
                map.put(c, node.left);
            }else{
                node.right = map.getOrDefault(c, new TreeNode(c));
                map.put(c, node.right);
            }
            map.put(p, node);
        }
        int root = -1;
        for(int[] d : descriptions){
            if(!set.contains(d[0])){
                root = d[0];
                break;
            }
        }
        return map.getOrDefault(root, null);
    }
}