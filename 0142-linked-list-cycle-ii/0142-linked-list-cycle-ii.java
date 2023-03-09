/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null)
            return null;
        ListNode s = head, f = head;
        boolean isCircle = false;
        while(s != null && f != null) {
            s = s.next;
            if(f.next == null)
                return null;
            f = f.next.next;
            if(s == f) {
                isCircle = true;
                break;
            }
        }
        if(isCircle) {
            f = head;
            while(s != f) {
                s = s.next;
                f = f.next;
            }
            return s;
        }
        return null;
    }
}