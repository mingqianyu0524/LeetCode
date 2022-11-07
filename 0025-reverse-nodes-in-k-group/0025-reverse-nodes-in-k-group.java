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
    private ListNode reverse(ListNode head, int k) {
        ListNode prev = null, cur = head;
        
        while (k > 0) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
            k--;
        }
        
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode ptr = head;
        
        while (count < k && ptr != null) {
            ptr = ptr.next;
            count++;
        }
        
        if (count == k) {
            ListNode reversed = this.reverse(head, k);
            head.next = reverseKGroup(ptr, k);
            return reversed;
        }
        
        return head;
    }
}