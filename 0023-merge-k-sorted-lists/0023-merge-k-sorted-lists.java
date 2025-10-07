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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(-1);
        ListNode point = head;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            new Comparator<ListNode>() {
                @Override
                public int compare(ListNode o1, ListNode o2) {
                    if (o1.val > o2.val) {
                        return 1;
                    } else if (o1.val == o2.val) {
                        return 0;
                    } else {
                        return -1;
                    }
                }
            }
        );
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }
        while (!pq.isEmpty()) {
            point.next = pq.poll();
            point = point.next;
            if (point.next != null) {
                pq.add(point.next);
            }
        }
        return head.next;
        
    }
}