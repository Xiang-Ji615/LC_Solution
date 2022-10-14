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
    public ListNode deleteMiddle(ListNode head) {
        ListNode res = head, fast = head, prev = head;
        if(head.next == null)
            return null;
        while(head != null && fast != null && fast.next != null){
            prev = head;
            head = head.next;
            fast = fast.next.next;
        }
        prev.next = head.next;
        return res;
    }
}