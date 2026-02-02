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


/**
Pointer     Meaning
dummy       Protects head
groupPrev   Node before current group
kth	        Last node in the group
groupNext	Node after the group
 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode groupPrev = dummy;

        while (true) {
            // 1. find kth node
            ListNode kth = groupPrev;
            for (int i = 0; i < k && kth != null; i++) {
                kth = kth.next;
            }
            if (kth == null) {
                break;
            }

            ListNode groupNext = kth.next;

            // 2. reverse group
            ListNode prev = groupNext;
            ListNode cur = groupPrev.next;
            while (cur != groupNext) {
                ListNode tmp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = tmp;
            }

            //3. reconnect
            ListNode tmp = groupPrev.next;  // will be tail
            groupPrev.next = kth;
            groupPrev = tmp;
        }
        return dummy.next;
    }
}