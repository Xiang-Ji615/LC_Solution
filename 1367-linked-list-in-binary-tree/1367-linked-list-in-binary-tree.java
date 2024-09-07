/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(head == null)
            return true;
        if(root == null)
            return false;
        return dfs(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }
    
    boolean dfs(ListNode head, TreeNode node){
        if(head == null)
            return true;
        if(node == null)
            return false;
        return head.val == node.val && (dfs(head.next, node.left) || dfs(head.next, node.right));
    }
}