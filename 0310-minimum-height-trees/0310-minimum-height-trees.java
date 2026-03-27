class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Arrays.asList(0);
        
        // build graph
        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<>());
        }

        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        // Initialize leaves
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        // Trim leaves
        int remainingNodes = n;

        while (remainingNodes > 2) {
            remainingNodes -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();

            for (int leaf : leaves) {
                int neighbor = graph.get(leaf).iterator().next(); // “Get the only neighbor of this leaf node”
                graph.get(neighbor).remove(leaf);

                if (graph.get(neighbor).size() == 1) {
                    newLeaves.add(neighbor);
                }
            }

            leaves = newLeaves;
        }
        return leaves;
        
    }
}


/**
Key Insight:
Instead of: “Try every node as root” ❌ (too slow) 
Think: "The root of MHT must be the center of the tree" ✅

What is the “center” of a tree?
    A tree can have:
       • 1 center (odd length path)
       • 2 centers (even length path)
       ❌ Never more than 2
    These centers are exactly the roots of Minimum Height Trees (MHTs).
    👉 These centers are the last remaining nodes after trimming leaves layer by layer

Strategy: Remove Leaves Layer by Layer
    Leaf = node with degree = 1
    Process:
    1.Build graph (adj list + degree array)
    2.Put all leaves into a queue
    3.Remove them level by level
    4.The last remaining nodes = answer

edges = [[1,0],[1,2],[1,3]]

1: 0, 2, 3
0: 1
2: 1
3: 1


edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]

3: 0, 1, 2, 4
0: 3
1: 3
2: 3
4: 3, 5
5: 4

 */