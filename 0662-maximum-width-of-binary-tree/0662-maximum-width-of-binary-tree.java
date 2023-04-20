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
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(root, 1));
        int res = 0;
        while(!q.isEmpty()){
            int size = q.size();
            int min = 0, max = 0;
            for(int i=0;i<size;i++){
                Node cur = q.poll();
                if(i == 0){
                    min = cur.p;
                }
                if(i == size - 1){
                    max = cur.p;
                }
                if(cur.node.left != null)
                    q.offer(new Node(cur.node.left, cur.p * 2));
                if(cur.node.right != null)
                    q.offer(new Node(cur.node.right, cur.p * 2 + 1));
            }
            res = Math.max(res, max - min + 1);
        }
        return res;
    }
    
    class Node {
        TreeNode node;
        int p;
        
        public Node(TreeNode node, int p){
            this.node =  node;
            this.p = p;
        }
    }
}