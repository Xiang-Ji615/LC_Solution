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
    public ListNode swapPairs(ListNode head) {
        ListNode node = new ListNode();
        node.next = head;
        ListNode tmp = node;
        while(tmp.next != null && tmp.next.next != null){
            ListNode first = tmp.next, second = tmp.next.next;
            first.next = second.next;
            second.next = first;
            tmp.next = second;
            tmp = tmp.next.next;
        }
        return node.next;
    }
}