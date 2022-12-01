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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sentinel = new ListNode(-1, head);
        dfs(sentinel, n);
        return sentinel.next;
    }
    private int dfs(ListNode cur, int n) {
        if (cur.next == null)
            return 1;
        int k = dfs(cur.next, n) + 1;
        if (k == n + 1)
            cur.next = cur.next.next;
        return k;
    }
}