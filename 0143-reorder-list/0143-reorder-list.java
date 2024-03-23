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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;
        ListNode s = head, f = head, prev = head, l1 = head;
        while(f != null && f.next != null){
            prev = s;
            s = s.next;
            f = f.next.next;
        }
        prev.next = null;
        ListNode l2 = reverse(s);
        merge(l1, l2);
        
    }
    
    ListNode reverse(ListNode node){
        ListNode res = null;
        while(node != null){
            ListNode next = node.next;
            node.next = res;
            res = node;
            node = next;
        }
        return res;
    }
    
    void merge(ListNode l1, ListNode l2){
        while(l1 != null){
            ListNode n1 = l1.next, n2 = l2.next;
            l1.next = l2;
            if(n1 == null)
                break;
            l2.next = n1;
            l1 = n1;
            l2 = n2;
        }
    }
}