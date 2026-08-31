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

/**
Two linked lists intersect if they share the same node reference, not the same value.

Idea: 
    - Pointer pA starts at headA
    - Pointer pB starts at headB
    - When a pointer reaches the end, jump it to the other list’s head

pA from headA: a1 a2 c1 c2 c3 b1 b2 b3 *c1 c2 c3 
pB from headB: b1 b2 b3 c1 c2 c3 a1 a2 *c1 c2 c3 

Eventually:
    - They either meet at the intersection
    - Or both reach null

Key logic:
    Each pointer travels:  lengthA + lengthB. So they are guaranteed to be aligned on the second pass.

 */

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = (pA == null) ? headB : pA.next;
            // if (pA == null) {
            //     pA = headB;
            // } else {
            //     pA = pA.next;
            // }

            pB = (pB == null) ? headA : pB.next;
            // if (pB == null) {
            //     pB = headA;
            // } else {
            //     pB = pB.next;
            // }
        }
        return pA;
    }
}