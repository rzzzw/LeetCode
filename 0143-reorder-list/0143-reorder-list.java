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
// class Solution {
//     public void reorderList(ListNode head) {
//         if (head == null || head.next == null || head.next.next == null) {
//             return;
//         }

//         ListNode slow = head;
//         ListNode fast = head;
//         while (fast.next != null && fast.next.next != null) {
//             slow = slow.next;
//             fast = fast.next.next;
//         }
//         fast = slow.next;
//         slow.next = null;
//         fast = reverse(fast);
//         slow = head;
//         while (fast != null) {
//             ListNode tmp = fast.next;
//             fast.next = slow.next;
//             slow.next = fast;
//             slow = fast.next;
//             fast = tmp;
//         }
//     }

//     private ListNode reverse(ListNode node) {
//         if (node.next == null) {
//             return node;
//         }
//         ListNode newHead = reverse(node.next);
//         node.next.next= node;
//         node.next = null;
//         return newHead;
//     }
// }

class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode one = head;
        ListNode two = slow.next;
        slow.next = null;
        two = reverse(two);

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (one != null && two != null) {
            cur.next = one;
            one = one.next;
            cur.next.next = two;
            two = two.next;
            cur = cur.next.next;
        }
        if (one != null) {
            cur.next = one;
        } else {
            cur.next = two;
        }
        head = dummy.next;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}

/**
     slow
1 --> 2 --> null

fast
4 --> 3
 */