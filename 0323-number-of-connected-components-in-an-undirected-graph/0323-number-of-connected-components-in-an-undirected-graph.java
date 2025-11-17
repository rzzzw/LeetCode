// 1. dfs   2. unionfind

// union-find with rank
// class Solution {
//     public int countComponents(int n, int[][] edges) {
//         int[] parent = new int[n];
//         int[] rank = new int[n];
//         for (int i = 0; i < n; i++) {
//             parent[i] = i;
//         }

//         int components = n;
//         for (int[] e : edges) {
//             if (union(e[0], e[1], parent, rank)) {
//                 components--;
//             }
//         }
//         return components;
//     }
//     private boolean union(int a, int b, int[] parent, int[] rank) {
//         int rootA = find(a, parent);
//         int rootB = find(b, parent);
//         if (rootA == rootB) { // [0,1][0,2][1,2]
//             return false;
//         }
//         if (rank[rootA] < rank[rootB]) {
//             parent[rootA] = rootB;
//         } else if (rank[rootA] > rank[rootB]) {
//             parent[rootB] = rootA;
//         } else {
//             parent[rootB] = rootA;
//             rank[rootA]++;
//         }
//         return true;
//     }
//     private int find(int x, int[] parent) {
//         if (parent[x] != x) {
//             parent[x] = find(parent[x], parent);
//         }
//         return parent[x];
//     }
// }

// union-find
// class Solution{
//     public int countComponents(int n, int[][] edges) {
//         int[] parent = new int[n];
//         for (int i = 0; i < n; i++) {
//             parent[i] = i;
//         }
//         int count = n;
//         for (int[] edge : edges){
//             int rootA = find(parent, edge[0]);
//             int rootB = find(parent, edge[1]);
//             if (rootA != rootB) {
//                 parent[rootA] = rootB;
//                 count--;
//             }
//         }
//         return count;
//     } 
//     private int find(int[] parent, int x) {
//         if (parent[x] != x) {
//             parent[x] = find(parent, parent[x]);
//         }
//         return parent[x];
//     } 
// }


// dfs
/** 
Example 1:
Input: n = 5, edges = [[0,1],[1,2],[3,4]]
Output: 2

graph:
        0:1
        1:2, 0
        2:1
        3:4
        4:3

visited:
    0 1 2 3 4 
    t t t

Complexity:
    time - O(E+V). 
        E = Number of edges, V = Number of vertices.
        Building the adjacency list will take O(E) operations; 
        During the DFS traversal, each vertex will only be visited once. 

    space - O(E+V)
        Building the adjacency list will take O(E) space.
        To keep track of visited vertices, an array of size O(V) is required. Also, the run-time stack for DFS will use O(V) space.

*/

class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(graph, visited, i);
                count++;
            }
        }
        return count;
    }
    private void dfs(List<List<Integer>> graph, boolean[] visited, int node) {
        visited[node] = true;
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(graph, visited, neighbor);
            }
        }
    }
}


