class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        // build graph
        for (int[] p : prerequisites) {
            int course = p[0];
            int prereq = p[1];

            graph.get(prereq).add(course);

            indegree[course]++;
        }

        Queue<Integer> q = new ArrayDeque<>();

        // put indegree 0 to Q 
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        List<Integer> res = new ArrayList<>();

        while (!q.isEmpty()) {
            int cur = q.poll();
            res.add(cur);
            for (int next : graph.get(cur)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        if (res.size() != numCourses) {
            return new int[]{};
        }

        int[] ans = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}

// class Solution {

//     public int[] findOrder(int numCourses, int[][] prerequisites) {

//         List<List<Integer>> graph = new ArrayList<>();

//         for (int i = 0; i < numCourses; i++) {
//             graph.add(new ArrayList<>());
//         }

//         int[] indegree = new int[numCourses];

//         // build graph
//         for (int[] p : prerequisites) {

//             int course = p[0];
//             int prereq = p[1];

//             graph.get(prereq).add(course);

//             indegree[course]++;
//         }

//         Queue<Integer> q = new ArrayDeque<>();

//         // add indegree 0 courses
//         for (int i = 0; i < numCourses; i++) {
//             if (indegree[i] == 0) {
//                 q.offer(i);
//             }
//         }

//         int[] order = new int[numCourses];
//         int idx = 0;

//         while (!q.isEmpty()) {

//             int cur = q.poll();

//             order[idx++] = cur;

//             for (int nei : graph.get(cur)) {

//                 indegree[nei]--;

//                 if (indegree[nei] == 0) {
//                     q.offer(nei);
//                 }
//             }
//         }

//         // cycle exists
//         if (idx != numCourses) {
//             return new int[0];
//         }

//         return order;
//     }
// }