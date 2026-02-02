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
//         ListNode head = new ListNode(-1);
//         ListNode point = head;
//         PriorityQueue<ListNode> pq = new PriorityQueue<>(
//             (a, b) -> Integer.compare(a.val, b.val)
//         );
//         for (ListNode node : lists) {
//             if (node != null) {
//                 pq.add(node);
//             }
//         }
//         while (!pq.isEmpty()) {
//             point.next = pq.poll();
//             point = point.next;
//             if (point.next != null) {
//                 pq.add(point.next);
//             }
//         }
//         return head.next;
        
//     }
// }
// TC: O(N log k) - k is the number of lists
// SC: O(k)

// class Solution{
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





class Solution{
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeRange(lists, 0, lists.length - 1);
    }
    private ListNode mergeRange(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int mid = left + (right - left) / 2;
        ListNode l1 = mergeRange(lists, left, mid);
        ListNode l2 = mergeRange(lists, mid + 1, right);
        return mergeTwoLists(l1, l2);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) {
            cur.next = l1;
        } else {
            cur.next = l2;
        }
        return dummy.next;
    }
}
// TC: O(N log k) - k is the number of lists
// SC: O(log k)