class LRUCache{
    class Node {
        int key, value;
        Node prev, next;
        Node(int k, int v) {
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

        //dummy nodes
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
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

}

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