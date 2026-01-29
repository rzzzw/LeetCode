 class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];

        // Initialize graph
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Build graph and indegree
        for (int[] p : prerequisites) {
            int course = p[0];
            int prereq = p[1];
            graph.get(prereq).add(course);
            indegree[course]++;
        }

        // Queue of course with no prerequisites
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int finished = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            finished++;

            for (int next : graph.get(cur)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        return finished == numCourses;
    }
 }

// class Solution {
//     public boolean canFinish(int numCourses, int[][] prerequisites) {
//         int[] indegree = new int[numCourses];
//         int res = numCourses;

//         for (int[] pair : prerequisites) {
//             indegree[pair[0]]++;
//         }

//         Queue<Integer> q = new ArrayDeque<>();
//         for (int i = 0; i < indegree.length; i++) {
//             if (indegree[i] == 0) {
//                 q.offer(i);
//                 res--;
//             }
//         }

//         while (!q.isEmpty()) {
//             int cur = q.poll();
//             for (int[] pair : prerequisites) {
//                 if (indegree[pair[0]] == 0) { // 如果入度为0， 表示这门课已经可以修了， 跳过
//                     continue;
//                 }
//                 if (pair[1] == cur) { // 要修pair[0]所需的先修课pair[1]已经可以修了，因此pair[0]的先修课可以 -1
//                     indegree[pair[0]]--;
//                 }

//                 if (indegree[pair[0]] == 0) {
//                     q.offer(pair[0]);
//                     res--;
//                 }
//             }
//         }
//         // for (int i = 0; i < numCourses; i++) {
//         //     if (indegree[i] != 0) {
//         //         return false;
//         //     }
//         // }
//         // return true;
//         return res == 0;
//     }
// }

/**
[1, 0] => 0->1   要修1 先修0
step 1: 
   int[] indegree: 记录每门课需要几门先修课   

    0 1 
      1

step 2: 把不需要先修课的课放进queue
    q: 0


 */




