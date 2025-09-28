class Solution {
    public boolean validTree(int n, int[][] edges) {
        /**
        A graph is a tree if:
        1. It has no cycles.
        2. It is fully connected (all n nodes are visited).       
         */
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        Map<Integer, Integer> parent = new HashMap<>(); // track parents in a Map<Integer, Integer> to detect cycles (if encounter a neighbor that is already visited but is not the parent → cycle).
        parent.put(0, -1);
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);

        while(!q.isEmpty()) {
            int node = q.poll();
            for (int nb : adjacencyList.get(node)) {
                if (parent.get(node) == nb) {
                    continue;
                }
                if (parent.containsKey(nb)) {
                    return false;
                }
                q.offer(nb);
                parent.put(nb, node);
            }
        }
        return parent.size() == n; //  Check if all nodes are connected
    }
}