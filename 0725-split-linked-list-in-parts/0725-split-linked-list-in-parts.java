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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] res = new ListNode[k];
        int l = 0;
        ListNode ref = head;
        while(ref != null){
            l++;
            ref = ref.next;
        }
        int n = l/k, r=l%k;
        ListNode prev = null;
        for(int i=0;head != null && i<k;i++,r--) {
            res[i] = head;
            for(int j=0;j<n+(r<=0? 0 : 1);j++) {
                prev = head;
                head = head.next;
            }
            prev.next = null;
        }
        return res;
    }
}