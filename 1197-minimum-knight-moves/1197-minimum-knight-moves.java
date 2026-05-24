/**
Key Observation: Symmetry
Knight movement is symmetric across:
    1. x-axis
    2. y-axis
    3. origin

So: (x, y) and (|x|, |y|) have the same answer.

Therefore:
    x = Math.abs(x);
    y = Math.abs(y);

Now we only search in the first quadrant.

BFS Idea
    Each state: (row, col)
    Knight has 8 moves:
        (+1,+2)
        (+2,+1)
        (-1,+2)
        (-2,+1)
        (+1,-2)
        (+2,-1)
        (-1,-2)
        (-2,-1)
    Expand layer by layer until reaching target.

Important Pruning Trick
    Even after symmetry, knight may temporarily move slightly negative.
    But we never need to go too far negative.
    Safe boundary:
        nx >= -2 && ny >= -2
    This dramatically reduces search space.
 */


// class Solution {

//     public int minKnightMoves(int x, int y) {

//         x = Math.abs(x);
//         y = Math.abs(y);

//         int[][] dirs = {
//             {1, 2}, {2, 1},
//             {-1, 2}, {-2, 1},
//             {1, -2}, {2, -1},
//             {-1, -2}, {-2, -1}
//         };

//         Queue<int[]> queue = new LinkedList<>();
//         Set<String> visited = new HashSet<>();

//         queue.offer(new int[]{0, 0});
//         visited.add("0,0");

//         int steps = 0;

//         while (!queue.isEmpty()) {

//             int size = queue.size();

//             for (int i = 0; i < size; i++) {

//                 int[] cur = queue.poll();

//                 int cx = cur[0];
//                 int cy = cur[1];

//                 if (cx == x && cy == y) {
//                     return steps;
//                 }

//                 for (int[] d : dirs) {

//                     int nx = cx + d[0];
//                     int ny = cy + d[1];

//                     // pruning
//                     if (nx >= -2 && ny >= -2) {

//                         String key = nx + "," + ny;

//                         if (!visited.contains(key)) {
//                             visited.add(key);
//                             queue.offer(new int[]{nx, ny});
//                         }
//                     }
//                 }
//             }

//             steps++;
//         }

//         return -1;
//     }
// }


class Solution {
    public int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);

        Map<String, Integer> memo = new HashMap<>();
        return dfs(x, y, memo);
    }

    private int dfs(int x, int y, Map<String, Integer> memo) {
        String key = x + "," + y;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // base cases
        if (x + y == 0) return 0;

        if (x + y == 2) return 2;

        int ans = 1 + Math.min(
            dfs(Math.abs(x - 1), Math.abs(y - 2), memo),
            dfs(Math.abs(x - 2), Math.abs(y - 1), memo)
        );

        memo.put(key, ans);

        return ans;
    }
}