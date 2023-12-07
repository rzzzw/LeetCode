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
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> (a.val - b.val));
        for (ListNode l : lists) {
            if (l != null) {
                queue.offer(l);
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        
        while (!queue.isEmpty()) {
            ListNode temp = queue.poll();
            cur.next = new ListNode(temp.val);
            cur = cur.next;
            if (temp.next != null) {
                queue.offer(temp.next);
            }
        }
        return dummy.next;
    }
}


/*
TC: O(nlogk)


    4
5       6



1 1 2 3 4 4 5 6

*/