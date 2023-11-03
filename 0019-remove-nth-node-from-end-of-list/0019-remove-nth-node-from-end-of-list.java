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

// traverse 1 time:
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode left = dummy;
        ListNode right = dummy;
        
        for (int i = 0; i <= n; i++) {
            right = right.next;
        }
        
        while (right != null) {
            right = right.next;
            left = left.next;
        }
        
        left.next = left.next.next;
        return dummy.next;
    }   
}

/*
    dummy head
     __    1   2   3   4   5
     l ->
               r ->
     |--- 2 ---|         
     
     l and r move in the same direction at the same time, with an interval of n.
*/



// traverse 2 times: 
// class Solution {
//     public ListNode removeNthFromEnd(ListNode head, int n) {
//         if (head == null) {
//             return null;
//         }
//         int size = 0;
//         ListNode cur = head;
//         // traverse the list to get the size.
//         while (cur != null) {
//             size++;
//             cur = cur.next;
//         }
        
//         // traverse the list again to remove the required node
//         ListNode dummy = new ListNode(0);
//         dummy.next = head;
//         cur = dummy;
        
//         for (int i = 0; i < size - n; i++) {
//             cur = cur.next;
//         }
//         cur.next = cur.next.next;
//         return dummy.next;
//     }
// }

// /*
// len = 5 ==> idx = 5 - 2 = 3
// TC: O(2L) ~ O(L)
// SC: O(1)

// */