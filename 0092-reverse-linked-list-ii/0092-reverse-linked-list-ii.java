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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null)
            return null;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        for(int i=0;i<m-1;i++){
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next = cur.next;
        for(int i=0;i<n-m;i++){
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
            next = cur.next;
        }
        return dummy.next;
    }
}