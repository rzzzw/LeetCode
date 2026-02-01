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
brute force: 2 passes
 */
// class Solution {
//     public ListNode removeNthFromEnd(ListNode head, int n) {
//         ListNode dummy = new ListNode(0);
//         dummy.next = head;
//         int length = 0;
//         ListNode cur = head;
//         while (cur != null) {
//             length++;
//             cur = cur.next;
//         }
//         length = length - n;
//         cur = dummy;
//         while (length > 0) {
//             cur = cur.next;
//             length--;
//         }
//         cur.next = cur.next.next;
//         return dummy.next;
//     }
    
// }

/**
slow-fast pointer: 1 pass
  - Move fast pointer n steps ahead
  - Move fast and slow together
  - When fast reaches end → slow is right before the node to delete
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        // Move fast n steps ahead
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // Move both until fast reaches the last node
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // remove the nth node from end
        slow.next = slow.next.next;

        return dummy.next;
    }
}