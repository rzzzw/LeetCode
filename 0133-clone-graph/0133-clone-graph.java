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
        if (node == null) return node;
        Map<Node, Node> map = new HashMap<>();
        copyNode(node, map);
        copyNeighbor(node, map, new HashSet<Node>());
        return map.get(node);
    }
    
    private void copyNode(Node node, Map<Node, Node> map) {
        if (map.containsKey(node))  return;
        map.put(node, new Node(node.val, new ArrayList<>()));
        for (Node nei : node.neighbors) {
            copyNode(nei, map);
        }
    }
    
    private void copyNeighbor(Node node, Map<Node, Node> map, HashSet<Node> visited) {
        if (visited.contains(node)) return;
        visited.add(node);
        
        for (Node nei : node.neighbors) {
            map.get(node).neighbors.add(map.get(nei));
            copyNeighbor(nei, map, visited);
        }
    }    
}