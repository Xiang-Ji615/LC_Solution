/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        return helper(head, null);
    }
    
    ListNode helper(ListNode node, ListNode res) {
        if(node == null)
            return res;
        ListNode next = node.next;
        node.next = res;
        return helper(next, node);
    }
}