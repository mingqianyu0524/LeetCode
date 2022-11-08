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
    private ListNode reverse(ListNode head) {
        ListNode prev = null, cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = reverse(l1);
        ListNode p2 = reverse(l2);
        int carry = 0;
        ListNode p = null;
        while (p1 != null || p2 != null) {
            int x1 = p1 != null ? p1.val : 0;
            int x2 = p2 != null ? p2.val : 0;
            
            int val = (x1 + x2 + carry) % 10;
            carry = (x1 + x2 + carry) / 10;
            
            p = new ListNode(val, p);
            p1 = p1 != null ? p1.next : null;
            p2 = p2 != null ? p2.next : null;
        }
        if (carry != 0) {
            p = new ListNode(carry, p);
        }
        return p;
    }
}