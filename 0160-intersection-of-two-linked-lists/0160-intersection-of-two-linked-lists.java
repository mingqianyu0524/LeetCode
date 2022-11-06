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
        Map<ListNode, Character> map = new HashMap<>();
        ListNode pa = headA, pb = headB;
        while (pa != null || pb != null) {
            // If a repeating node is found, return it.
            if (pa == pb || map.containsKey(pa)) {
                return pa;
            } 
            if (pa == pb || map.containsKey(pb)) {
                return pb;
            }
            // If it's a new node, store it in map and update pointer.
            if (pa != null) {
                map.put(pa, 'A');
                pa = pa.next;
            }
            
            if (pb != null) {
                map.put(pb, 'B');
                pb = pb.next;
            }
            
        }
        return null;
    }
}