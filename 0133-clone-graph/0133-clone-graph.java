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
// class Solution {
//     public Node cloneGraph(Node node) {
//         if (node == null) {
//             return node;
//         }
//         HashMap<Node, Node> visited = new HashMap<>();  // keep track of visited nodes.
//         return helper(node, visited);
//     }

//     private Node helper(Node node, HashMap<Node, Node> visited) {
//         if (visited.containsKey(node)) {
//             return visited.get(node);
//         }

//         // Create a new clone node
//         Node cloneNode = new Node(node.val, new ArrayList<>());
//         visited.put(node, cloneNode);

//         // Clone neighbors

//         for (Node neighbor : node.neighbors) {
//             cloneNode.neighbors.add(helper(neighbor, visited));
//                                     // If the neighbor has already been cloned, helper just returns the existing clone from visited.
//                                     // If not, helper creates a brand-new clone for that neighbor and all its connections.
            
//         }


//         return cloneNode;
//     }
// }

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> visited = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        Node clone = new Node(node.val, new ArrayList<>());
        visited.put(node, clone);
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (Node nb : cur.neighbors) {
                if (!visited.containsKey(nb)) {
                    visited.put(nb, new Node(nb.val, new ArrayList<>())); // create copy of neighbor node, and put it as placeholder in the visited map 
                    queue.offer(nb);
                }
                visited.get(cur).neighbors.add(visited.get(nb));    // Link current clone to neighbor clone                     
            }
        }
        return clone;
    }
}