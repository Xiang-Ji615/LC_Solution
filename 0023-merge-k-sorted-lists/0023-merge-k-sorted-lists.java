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
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        for(ListNode node : lists) {
            while(node != null) {
                minHeap.add(node.val);
                node = node.next;
            }
        }
        ListNode res = new ListNode();
        ListNode ref = res;
        while(!minHeap.isEmpty()) {
            ref.next = new ListNode(minHeap.poll());
            ref = ref.next;
        }
        return res.next;
    }
}