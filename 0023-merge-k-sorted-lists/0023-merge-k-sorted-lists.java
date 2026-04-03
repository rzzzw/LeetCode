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
//     public ListNode mergeKLists(ListNode[] lists) {
//         if (lists == null || lists.length == 0) {
//             return null;
//         }
//         return mergeRange(lists, 0, lists.length - 1);
//     }

//     private ListNode mergeRange(ListNode[] lists, int left, int right) {
//         if (left == right) {
//             return lists[left];
//         }
//         int mid = left + (right - left) / 2;
//         ListNode l1 = mergeRange(lists, left, mid);
//         ListNode l2 = mergeRange(lists, mid + 1, right);
//         return mergeTwoLists(l1, l2);
//     }

//     private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//         ListNode dummy = new ListNode(-1);
//         ListNode cur = dummy;
//         while (l1 != null && l2 != null) {
//             if (l1.val < l2.val) {
//                 cur.next = l1;
//                 l1 = l1.next;
//             } else {
//                 cur.next = l2;
//                 l2 = l2.next;
//             }
//             cur = cur.next;
//         }
//         if (l1 != null) {
//             cur.next = l1;
//         } else {
//             cur.next = l2;
//         }
//         return dummy.next;
//     }
// }
/**
TC: O(N log k)  (N = total nodes across ALL lists; k = number of lists)
    • Each merge = O(n).  (n = total number of nodes in the two lists being merged)
    • Total levels = log k. (k is the number of lists)
SC: O(log k)

Why not O(N²)? Because each node gets merged multiple times, but only log k times.
    • Each node participates in log k merges
    • Not k merges

Think: 
    Level 1: merge pairs → N work
    Level 2: merge results → N work
    ...
    Total levels = log k

    So: N + N + N + ... (log k times) = N log k
 */


class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a, b) -> a.val - b.val
        );

        // Step 1: add all heads
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        // Step 2: process heap
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();   // smallest node
            cur.next = node;
            cur = cur.next;

            if (node.next != null) {
                pq.offer(node.next);    // push next node
            }
        }

        return dummy.next;
    }
}
/**
• Heap size = k
• Each node: 
    • insert -> O(log k)
    • remove -> O(log k)

TC: O(N log k)
    • N = total nodes
    • k = number of lists
SC: O(k)

 */




