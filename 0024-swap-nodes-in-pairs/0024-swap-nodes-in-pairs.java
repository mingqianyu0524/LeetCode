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
        ListNode n1 = head;
        if (n1 == null) return n1;
        ListNode n2 = n1.next;
        if (n2 == null) return n1;
        
        n1.next = swapPairs(n2.next);
        n2.next = n1;
        return n2;
    }
}