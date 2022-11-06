/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode pa = headA, pb = headB;
        while (pa != null || pb != null) {
            if (pa == pb || set.contains(pa)) {
                return pa;
            } 
            if (pa == pb || set.contains(pb)) {
                return pb;
            }
            if (pa != null) {
                set.add(pa);
                pa = pa.next;
            }
            
            if (pb != null) {
                set.add(pb);
                pb = pb.next;
            }
            
        }
        return null;
    }
}