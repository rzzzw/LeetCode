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
//     public ListNode reverseList(ListNode head) {
//         if (head == null || head.next == null) {
//             return head;
//         }
//         ListNode newHead = reverseList(head.next);
//         head.next.next = head;
//         head.next = null;
//         return newHead;
//     }
// }

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev;
    }
}

/**
reverse(node 1)
    
            reverse (node 2)
                    newHead = node 2 
            <=      node1.next.next = node2.next = node1 
                    node1.next = null 

 */