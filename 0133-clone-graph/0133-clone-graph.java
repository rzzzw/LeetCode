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

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        HashMap<Node, Node> visited = new HashMap<>();
        return helper(node, visited);
    }

    private Node helper(Node node, HashMap<Node, Node> visited) {
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // Create a new clone node
        Node cloneNode = new Node(node.val, new ArrayList<>());
        visited.put(node, cloneNode);

        // Clone neighbors
        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(helper(neighbor, visited));
                                    // If the neighbor has already been cloned, helper just returns the existing clone from visited.
                                    // If not, helper creates a brand-new clone for that neighbor and all its connections.
            
        }

        return cloneNode;
    }
}