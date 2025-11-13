// union-find
class Solution{
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int count = n;
        for (int[] edge : edges){
            int rootA = find(parent, edge[0]);
            int rootB = find(parent, edge[1]);
            if (rootA != rootB) {
                parent[rootA] = rootB;
                count--;
            }
        }
        return count;
    } 
    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    } 
}


// dfs
// class Solution {
//     public int countComponents(int n, int[][] edges) {
//         List<List<Integer>> graph = new ArrayList<>();
//         for (int i = 0; i < n; i++) {
//             graph.add(new ArrayList<>());
//         }
//         for (int[] e : edges) {
//             graph.get(e[0]).add(e[1]);
//             graph.get(e[1]).add(e[0]);
//         }
//         boolean[] visited = new boolean[n];
//         int count = 0;
//         for (int i = 0; i < n; i++) {
//             if (!visited[i]) {
//                 dfs(graph, visited, i);
//                 count++;
//             }
//         }
//         return count;
//     }
//     private void dfs(List<List<Integer>> graph, boolean[] visited, int node) {
//         visited[node] = true;
//         for (int neighbor : graph.get(node)) {
//             if (!visited[neighbor]) {
//                 dfs(graph, visited, neighbor);
//             }
//         }
//     }
// }