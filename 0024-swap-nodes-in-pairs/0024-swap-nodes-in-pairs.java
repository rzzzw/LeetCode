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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode pre = dummy;  // dummy will be used to return the result, can iterate with dummy directly, or you'll lost the linkage
        while (head != null && head.next != null) {
            ListNode first = head;
            ListNode second = head.next;
            
            pre.next = second;
            first.next = second.next;
            second.next = first;
            
            pre = first;
            head = first.next;
        }
        return dummy.next;
        
    }
}

/*
*/