class LRUCache {
    
    private class Node {
        int key;
        int value;
        Node next;
        Node pre;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }
    
    private Map<Integer, Node> map;
    private int capacity;
    private Node head; // the oldest element
    private Node tail; // the newest element 

    public LRUCache(int capacity) {
        // initialization
        map = new HashMap<>();
        this.capacity = capacity;
        head = null;
        tail = null;
        
        
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        if (node != tail) {     // if node == tail => return directly
            if (node == head) {     // move to the tail
                head = head.next;
                
            } else {
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }
            tail.next = node;
            node.pre = tail;
            node.next = null;
            tail = node;
        } 
        return node.value;        
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        // if node exist, update the value
        if (node != null) {
            node.value = value;
            if (node != tail) {
                if (node == head) {
                    head = head.next;
                } else {
                    node.pre.next = node.next;
                    node.next.pre = node.pre;
                }
                tail.next = node;
                node.pre = tail;
                node.next = null;
                tail = node;
            }
        } else {
            Node newNode = new Node(key, value);
            if (capacity == 0) {
                Node temp = head;
                head = head.next;
                map.remove(temp.key); // remove from map accordingly
                capacity++;
            }
            if (head == null) {
                head = newNode;
            } else {
                tail.next = newNode;
                newNode.pre = tail;
                newNode.next = null;               
            }
            tail = newNode;   
            map.put(key, newNode);      
            capacity--;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */