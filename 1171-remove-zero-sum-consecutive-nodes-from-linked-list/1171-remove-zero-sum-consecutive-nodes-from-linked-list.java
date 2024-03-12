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
    public ListNode removeZeroSumSublists(ListNode head) {
        if(head == null)
            return head;
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        dummy.next = head;
        int sum = 0;
        while(cur != null) {
            sum += cur.val;
            if(map.containsKey(sum)) {
                cur = map.get(sum).next;
                int p = sum + cur.val;
                while(p != sum) {
                    map.remove(p);
                    cur = cur.next;
                    p += cur.val;
                }
                map.get(sum).next = cur.next;
            }else {
                map.put(sum, cur);
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}