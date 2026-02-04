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
Merge sort is the only sorting algorithm that fits linked lists perfectly
 */


class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // step 1: split the list
        ListNode mid = getMid(head);
        ListNode right = mid.next;
        mid.next = null;

        // step 2: sort both halves
        ListNode leftSorted = sortList(head);
        ListNode rightSorted = sortList(right);

        // step 3: merge
        return merge(leftSorted, rightSorted);
    }

    private ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Merge two sorted lists
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        cur.next = (l1 == null) ? l2 : l1;
        return dummy.next;
    }
}

