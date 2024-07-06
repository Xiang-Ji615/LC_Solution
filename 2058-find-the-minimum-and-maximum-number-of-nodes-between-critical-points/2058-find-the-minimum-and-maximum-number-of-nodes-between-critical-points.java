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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int first = Integer.MAX_VALUE, last = 0, prevVal = head.val, min = Integer.MAX_VALUE;
        for(int i=0;head.next != null;i++){
            if((prevVal < head.val && head.val > head.next.val) || (prevVal > head.val && head.val < head.next.val)){
                if(last != 0){
                    min = Math.min(min, i - last);
                }
                first = Math.min(first, i);
                last = i;
            }
            prevVal = head.val;
            head = head.next;
        }
        if(min == Integer.MAX_VALUE)
            return new int[]{-1, -1};
        return new int[]{min, last - first};
    }
}