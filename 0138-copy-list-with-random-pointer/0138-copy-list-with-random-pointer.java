/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

// class Solution {
//     public Node copyRandomList(Node head) {
//         if (head == null) return null;
//         Map<Node, Node> map = new HashMap<>(); // key: ori node; val: copied node
//         Node newHead = new Node(head.val);
//         map.put(head, newHead);

//         Node cur = newHead;
//         while (head != null) {
//             if (head.next != null) {
//                 if (!map.containsKey(head.next)) {
//                     map.put(head.next, new Node(head.next.val));
//                 }
//                 cur.next = map.get(head.next);
//             }
//             if (head.random != null) {
//                 if (!map.containsKey(head.random)) {
//                     map.put(head.random, new Node(head.random.val));
//                 }
//                 cur.random = map.get(head.random);
//             }
//             head = head.next;
//             cur = cur.next;
//         }
//         return newHead;
//     }
// }

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();

        // 1st pass: create all nodes
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        // 2nd pass: assign next and random
        cur = head;
        while (cur != null) {
            Node copy = map.get(cur);
            copy.next = map.get(cur.next);
            copy.random = map.get(cur.random);
            cur = cur.next;
        }

        return map.get(head);
    }
}