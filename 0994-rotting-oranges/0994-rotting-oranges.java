class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> q = new ArrayDeque<>();
        int fresh = 0;

        // Step 1: Initialize queue with all rotten oranges
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    q.offer(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) {
            return 0;
        }

        int minutes = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

        while (!q.isEmpty()) {
            int size = q.size();
            boolean rottedThisMinute = false; 

            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];

                for (int[] d : dirs) {
                    int nr = r + d[0];
                    int nc = c + d[1];
                    if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) {
                        continue;
                    }

                    if (grid[nr][nc] != 1) {
                        continue;
                    }

                    grid[nr][nc] = 2;
                    fresh--;
                    q.offer(new int[]{nr, nc});  // previous error: q.offer(grid[nr][nc]);
                    rottedThisMinute = true; // within this BFS level, as long as there's 1 node with 1 direction found as a fresh, it turns true.
                }
            }
            if (rottedThisMinute) {
                minutes++;
            }
        } 
        return fresh == 0 ? minutes : -1;
    } 
}

/**
Time Complexity: Each cell processed once → O(R × C)

Space Complexity: Queue may hold all cells → O(R × C)


Optimization:
while (!q.isEmpty()) {
    int size = q.size();
    for (int i = 0; i < size; i++) {
        ...
    }
    if (!q.isEmpty()) minutes++;
}
 */