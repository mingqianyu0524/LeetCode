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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode sentinel = new ListNode(-1, head);
        ListNode p = sentinel;
        for (int i = 0; i < m-1; i++) {
            p = p.next;
        }
        // reverse
        ListNode pre = null, cur = p.next;
        for (int i = 0; i < n-m+1; i++) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        ListNode nxt = p.next;
        p.next = pre;
        nxt.next = cur;
        return sentinel.next;
    }
}