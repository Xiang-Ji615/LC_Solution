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
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode s = head, f = head;
        while(f != null && f.next != null){
            stack.push(s.val);
            s = s.next;
            f = f.next.next;
        }
        if(f != null)
            s = s.next;
        while(s != null){
            if(stack.isEmpty() || stack.pop() != s.val)
                return false;
            s = s.next;
        }
        return true;
    }
}