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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }
        
        ListNode cur = prev.next;
        
        for (int i = left; i < right; i++) {
            ListNode next = cur.next; // re-assign next node for each iteration
            cur.next = next.next;
            next.next = prev.next; // why not cur?
            prev.next = next;
        }
        return dummy.next;
    }
}

/*
1st iteration:
  pre  cur next
    1   2   3   4   5
    
  pre next cur 
    1   3   2   4   5   
-----------------------------------
2nd iteration:
  pre      cur next
    1   3   2   4   5 
    
  pre  next    cur
    1   4   3   2   5 
-----------------------------------




*/