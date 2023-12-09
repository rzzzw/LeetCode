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
    public ListNode reverseKGroup(ListNode head, int k) {
        // base case
        if (head == null || head.next == null) {
            return head;
        }
        
        int count = 0;
        ListNode cur = head;
        while(cur != null && count != k){
            cur = cur.next;
            count++;
        }
        
        if(count == k){
            cur = reverseKGroup(cur, k);
            while (count-- > 0){
                ListNode temp = head.next;
                head.next = cur;
                cur = head;
                head = temp;
            }
            head = cur;
        }

        return head;
    }
}