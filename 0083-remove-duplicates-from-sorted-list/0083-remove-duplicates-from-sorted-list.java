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
    public ListNode deleteDuplicates(ListNode head) {
        Set<Integer> set = new HashSet<>();
        ListNode prev = head;
        if (head == null) return head;
        set.add(head.val);
        while (prev.next != null) {
            if (set.contains(prev.next.val)) {
                prev = deleteNode(prev);
            } else {
                set.add(prev.next.val);
                prev = prev.next;
            }
        }
        return head;
    }
    private ListNode deleteNode(ListNode prev) {
        prev.next = prev.next.next;
        return prev;
    }
}