/**
Key Idea
To achieve O(1), combine
1. HashMap
    • key -> Node
    • Fast lookup

2. Doubly Linked List
    • Maintain usage order
    • Most recently used -> front
    • Least recently used -> back

 */


class LRUCache {

    class Node {
        int key, value;
        Node prev, next;
        Node (int k, int v) {
            key = k;
            value = v;
        }
    }

    private int capacity;
    private Map<Integer, Node> map;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        // dummy nodes
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        moveToFront(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            moveToFront(node);
        } else {
            if (map.size() == capacity) {
                Node lru = tail.prev;
                remove(lru);
                map.remove(lru.key);
            }
            Node node = new Node(key, value);
            addToFront(node);
            map.put(key, node);
        }
    }
    
    private void moveToFront(Node node) {
        remove(node);
        addToFront(node);
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToFront(Node node) {
        head.next.prev = node;
        node.next = head.next;
        head.next = node;
        node.prev = head;
    }
} 



/**
the node is inserted to the head by "node.next = head.next; node.prev = head;", why still need "head.next.prev = node; head.next = node; "?

I want:   head <-> node <-> oldFirst  ❗❗BOTH sides must acknowledge it.

With:     node.next = head.next;
          node.prev = head;  
    
    The structure looks like:
                                head    oldFirst
                                    \     /
                                     node
        node.prev = head ✅
        node.next = oldFirst ✅    

    But ❗👉 The rest of the list does NOT know about node yet. ❗ What’s missing?
    Currently:
        head.next = oldFirst
        oldFirst.prev = head   

    So the list is still:
                                head <--> oldFirst
                                    \     /
                                      node (the new node is just floating, not connected properly.)



So these two lines are needed:

    head.next.prev = node;   <-- oldFirst.prev = node   👉 Now oldFirst correctly points back to node
    head.next = node;       👉 Now head correctly points forward to node

 */


// class LRUCache {
//     private int capacity;
//     private Map<Integer, Node> map;
//     private Node head;
//     private Node tail;

//     public LRUCache(int capacity) {
//         this.capacity = capacity;
//         map = new HashMap<>();
//         head = new Node(-1, -1);
//         tail = new Node(-1, -1);
//         head.next = tail;
//         tail.pre = head;
//     }
    
//     public int get(int key) {
//         Node node = map.get(key);
//         if (node != null) {
//             updateNodeList(node);
//             return node.val;
//         }
//         return -1;
//     }
    
//     public void put(int key, int value) {
//         Node node = map.get(key);
//         if (node != null) {
//             node.val = value;
//             updateNodeList(node);
//         } else {
//             node = new Node(key, value);
//             insertNode(node);
//             if (map.size() > capacity) {
//                 removeLastNode();
//             }
//         }
//     }
    
//     private void removeLastNode() {
//         Node last = tail.pre;
//         map.remove(last.key);
//         Node pre = last.pre;
//         pre.next = tail;
//         tail.pre = pre;
//     }
    
//     private void insertNode(Node node) {
//         map.put(node.key, node);
//         Node next = head.next;
//         head.next = node;
//         node.pre = head;
//         node.next = next;
//         next.pre = node;
//     }
    
//     private void updateNodeList(Node node) {
//         Node pre = node.pre;
//         Node next = node.next;
//         pre.next = next;
//         next.pre = pre;
//         next = head.next;
//         head.next = node;
//         node.pre = head;
//         node.next = next;
//         next.pre = node;
//     }
    
//     private class Node {
//         int key;
//         int val;
//         Node next;
//         Node pre;
        
//         public Node(int key, int val) {
//             this.key = key;
//             this.val = val;
//         }
//     }
// }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */