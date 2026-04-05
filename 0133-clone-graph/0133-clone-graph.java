/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
/*
DFS： 
    1. If the node is in the map → return its clone.
    2. Otherwise, create a new clone node with the same value.
    3. Store it in the map before exploring neighbors (prevents cycles).
    4. For each neighbor, recursively clone and add the clone to the neighbors list.
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        Map<Node, Node> visited = new HashMap<>(); // keep track of visited nodes.
        return helper(node, visited);
    }

    private Node helper(Node node, Map<Node, Node> visited) {
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // Create a new clone node
        Node clone = new Node(node.val, new ArrayList<>());
        visited.put(node, clone);

        // Clone neighbors
        for (Node nb : node.neighbors) {
            clone.neighbors.add(helper(nb, visited));
                                    // If the neighbor has already been cloned, helper just returns the existing clone from visited.
                                    // If not, helper creates a brand-new clone for that neighbor and all its connections.            
        }
        return clone;
    }
}

// BFS：

// class Solution {
//     public Node cloneGraph(Node node) {
//         if (node == null) {
//             return null;
//         }
//         Map<Node, Node> visited = new HashMap<>();
//         Deque<Node> queue = new ArrayDeque<>();  // Queue<Node> queue = new LinkedList<>(); .offer()/ .poll()
//         Node clone = new Node(node.val, new ArrayList<>());
//         visited.put(node, clone);
//         queue.offer(node);
//         while (!queue.isEmpty()) {
//             Node cur = queue.pollFirst();
//             for (Node nb : cur.neighbors) {
//                 if (!visited.containsKey(nb)) {
//                     visited.put(nb, new Node(nb.val, new ArrayList<>())); // create copy of neighbor node, and put it as placeholder in the visited map 
//                     queue.offerLast(nb);
//                 }
//                 /**
//                 cloned(cur).neighbors.add(cloned(neighbor))   
//                 1. Look at each original neighbor
//                 2. Add the corresponding cloned neighbor
//                 3. To the cloned version of curr               
//                  */
//                 visited.get(cur).neighbors.add(visited.get(nb)); // Add the cloned neighbor to the cloned current node's neighbor list    
//             }
//         }
//         return clone;
//     }
// }
