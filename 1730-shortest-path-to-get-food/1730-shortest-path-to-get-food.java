class Solution {
    private static final int[][] DIRS = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    
    public int getFood(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> q = new ArrayDeque<>();
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '*') {
                    q.offer(new int[]{r, c});
                } 
            }
        }

        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] cur = q.poll();
                for (int[] d : DIRS){
                    int nr = cur[0] + d[0];
                    int nc = cur[1] + d[1];
                    if (nr < 0 || nc < 0 || nr >= rows || nc >= cols) {
                        continue;
                    } else if (grid[nr][nc] == '#') {
                        return steps + 1;
                    } else if (grid[nr][nc] == 'O') {
                        q.offer(new int[]{nr, nc});
                        grid[nr][nc] = 'X';
                    }
                }

            }
            steps++;
        }
        return -1;
    }

}


// class Solution {
//     private static final int[][] DIRS = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    
//     public int getFood(char[][] grid) {
//         if (grid == null || grid.length == 0 || grid[0].length == 0) {
//             return -1;
//         }
//         int rows = grid.length;
//         int cols = grid[0].length;

//         int[] shortest = new int[]{Integer.MAX_VALUE};

//         for (int r = 0; r < rows; r++) {
//             for (int c = 0; c < cols; c++) {
//                 if (grid[r][c] == '*') {
//                     dfs(grid, r, c, 0, shortest);
//                 }
//             }
//         }
//         return shortest[0] == Integer.MAX_VALUE ? -1 : shortest[0];
//     }

//     private void dfs(char[][] grid, int r, int c, int steps, int[] shortest) {
//         // boundary
//         if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 'X') {
//             return;
//         }

//         // found food
//         //      note: why don't mark visited for the food cell? Mark visited when: recursion will continue from this node; No need mark when: recursion terminates immediately.  Think the food cell as a destination.
//         if (grid[r][c] == '#') {
//             shortest[0] = Math.min(shortest[0], steps);
//             return;
//         }


//         // mark visited to 'X'
//         char temp = grid[r][c];
//         grid[r][c] = 'X';

//         for (int[] d : DIRS) {
//             int nr = r + d[0];
//             int nc = c + d[1];
//             dfs(grid, nr, nc, steps + 1, shortest);
//         }

//         grid[r][c] = temp;
//     }
// }
